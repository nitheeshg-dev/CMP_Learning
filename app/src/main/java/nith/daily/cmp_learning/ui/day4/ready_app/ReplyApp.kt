package nith.daily.cmp_learning.ui.day4.ready_app

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import nith.daily.cmp_learning.data.Email
import nith.daily.cmp_learning.data.MailboxType
import nith.daily.cmp_learning.ui.theme.ReplyTheme
import nith.daily.cmp_learning.ui.utils.ReplyContentType
import nith.daily.cmp_learning.ui.utils.ReplyNavigationType
import nith.daily.cmp_learning.ui.utils.ReplyNavigationType.*

@Composable
fun ReplyApp(windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val viewModel: ReplyViewModel = viewModel()
    val replyUiState = viewModel.uiState.collectAsStateWithLifecycle().value
    val navigationType: ReplyNavigationType
    val contentType: ReplyContentType
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = NAVIGATION_RAIL
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = PERMANENT_NAVIGATION_DRAWER
            contentType = ReplyContentType.LIST_AND_DETAIL
        }
        else -> {
            navigationType = BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
    }

    ReplyHomeScreen(navigationType = navigationType,
        contentType,
        replyUiState = replyUiState,
        onTabPressed = { mailboxType: MailboxType ->
            viewModel.updateCurrentMailbox(mailboxType = mailboxType)
            viewModel.resetHomeScreenStates()
        },
        onEmailCardPressed = { email: Email ->
            viewModel.updateDetailsScreenStates(
                email = email
            )
        },
        onDetailScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewDetails(){
    ReplyTheme{
        ReplyApp()
    }

}