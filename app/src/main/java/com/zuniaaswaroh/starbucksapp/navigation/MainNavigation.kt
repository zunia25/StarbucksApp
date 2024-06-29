package com.nameisjayant.starbucksapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nameisjayant.starbucksapp.screens.HomeScreen
import com.nameisjayant.starbucksapp.screens.ProductDetailScreen
import com.nameisjayant.starbucksapp.screens.SignInScreen
import com.nameisjayant.starbucksapp.screens.SignUpScreen
import com.nameisjayant.starbucksapp.screens.StartScreen


@Composable
fun MainNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = SPLASH_SCREEN ){
        composable(SPLASH_SCREEN){
            StartScreen(navHostController)
        }
        composable(HOME_SCREEN){
            HomeScreen(navHostController)
        }
        composable(DETAIL_SCREEN){
            ProductDetailScreen(navHostController)
        }
        composable(SIGNIN_SCREEN){
            SignInScreen(
                onSignInClick = {
                    navHostController.navigate(
                        HOME_SCREEN
                    )
                },
                onSignUpClick = {
                    navHostController.navigate(
                        SIGNUP_SCREEN
                    )
                }
            )
        }
        composable(SIGNUP_SCREEN){
            SignUpScreen(
                onSignUpClick = {
                    navHostController.navigate(
                        HOME_SCREEN
                    )
                },
                onSignInClick = {
                    navHostController.navigate(
                        SIGNIN_SCREEN
                    )
                }
            )
        }

    }

}

const val SPLASH_SCREEN = "splash_screen"
const val  HOME_SCREEN = "home_screen"
const val DETAIL_SCREEN = "detail_screen"
const val SIGNUP_SCREEN = "signup_screen"
const val SIGNIN_SCREEN = "signin_screen"