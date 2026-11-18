package nith.daily.cmp_learning.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import nith.daily.cmp_learning.data.LoginSate
import kotlin.time.Duration.Companion.milliseconds

class LoginViewModel: ViewModel() {
    private val navigationChannel = Channel<NavigationEvent>()
    val navigationEventChannelFlow = navigationChannel.receiveAsFlow()

    private val _navigationEvents = MutableSharedFlow<NavigationEvent>(replay = 3)
    val navigationEventSharedFlow = _navigationEvents.asSharedFlow()

    var isLoggedIn by mutableStateOf(false)
        private set

    var state by mutableStateOf(LoginSate())
        private set

    fun login(){
        /*viewModelScope.launch {
            repeat(1000){
                delay(3L.milliseconds)
                navigationChannel.send(NavigationEvent.CountEvent(it))
            }
        }*/
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            delay(3000L.milliseconds)
//            channels
            navigationChannel.send(NavigationEvent.NavigateToProfile)
//            shareFlow
//            _navigationEvents.emit(NavigationEvent.NavigateToProfile)
            state = state.copy(isLoading = false, isLoggedIn = true)
        }
    }
}

sealed interface NavigationEvent{
    object NavigateToProfile: NavigationEvent
    data class CountEvent(val count:Int): NavigationEvent
}
