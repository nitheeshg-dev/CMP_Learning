package nith.daily.cmp_learning.ui.day4.ready_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import nith.daily.cmp_learning.data.Email
import nith.daily.cmp_learning.data.MailboxType
import nith.daily.cmp_learning.ui.theme.ReplyTheme

@Composable
fun ReplyApp(
    modifier: Modifier = Modifier,
) {
    val viewModel: ReplyViewModel = viewModel()
    val replyUiState = viewModel.uiState.collectAsState().value

    ReplyHomeScreen(
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