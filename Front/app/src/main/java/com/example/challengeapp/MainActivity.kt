package com.example.challengeapp

import CheckInViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.challengeapp.ui.screens.auth.LoginScreen
import com.example.challengeapp.ui.screens.auth.SignUpScreen
import com.example.challengeapp.ui.screens.checkin.CheckInScreen
import com.example.challengeapp.ui.screens.checkin.NoteScreen
import com.example.challengeapp.ui.screens.dashboard.DashboardScreen
import com.example.challengeapp.ui.screens.onboarding.HelloScreen1
import com.example.challengeapp.ui.screens.onboarding.HelloScreen2
import com.example.challengeapp.ui.screens.onboarding.HelloScreen3
import com.example.challengeapp.ui.theme.ChallengeAppTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ChallengeAppTheme {
                val navController = rememberNavController()
                val checkInViewModel: CheckInViewModel = viewModel() // pega uma única instância aqui

                Surface(color = Color.White) {
                    NavHost(
                        navController = navController,
                        startDestination = "hello1",
                        enterTransition = { slideInHorizontally(
                            initialOffsetX = { fullWidth -> fullWidth }, // entra da direita
                            animationSpec = tween(300)
                        ) },
                        exitTransition = { slideOutHorizontally(
                            targetOffsetX = { fullWidth -> -fullWidth }, // sai para esquerda
                            animationSpec = tween(300)
                        ) },
                        popEnterTransition = { slideInHorizontally(
                            initialOffsetX = { fullWidth -> -fullWidth }, // entra da esquerda no pop
                            animationSpec = tween(300)
                        ) },
                        popExitTransition = { slideOutHorizontally(
                            targetOffsetX = { fullWidth -> fullWidth }, // sai para direita no pop
                            animationSpec = tween(300)
                        ) }

                    ) {
                        composable("hello1") { HelloScreen1(navController) }
                        composable("hello2") { HelloScreen2(navController) }
                        composable("hello3") { HelloScreen3(navController) }
                        composable("signUp") { SignUpScreen(navController) }
                        composable("login") { LoginScreen(navController) }

                        composable("dashboard") {
                            DashboardScreen(
                                navController,
                                onCardClick = { navController.navigate("checkIn") },
                                viewModel = checkInViewModel
                            )
                        }
                        composable("checkIn") {
                            CheckInScreen(
                                navController,
                                viewModel = checkInViewModel
                            )
                        }
                        composable("note") {
                            NoteScreen(
                                navController,
                                viewModel = checkInViewModel
                            )
                        }
                    }
                }
            }
        }

    }
}

