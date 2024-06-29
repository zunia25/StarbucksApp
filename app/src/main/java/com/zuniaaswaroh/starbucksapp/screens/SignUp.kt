package com.nameisjayant.starbucksapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nameisjayant.starbucksapp.R
import com.nameisjayant.starbucksapp.componen.TextFieldInput
import com.nameisjayant.starbucksapp.ui.theme.DarkGreen


@Composable
fun SignUpScreen(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit,
//    onPolicyClick: () -> Unit,
//    onPrivacyClick: () -> Unit
) {
    val (email, setEmail) = rememberSaveable {
        mutableStateOf("")
    }

    val (password, setPassword) = rememberSaveable {
        mutableStateOf("")
    }

//    val (agree, onAgreeChange) = rememberSaveable {
//        mutableStateOf(false)
//    }

//    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 52.dp,
                vertical = 52.dp
            ),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(125.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            text = "Sign Up",
            fontSize = 28.sp,
            fontWeight = FontWeight.W500
        )
        Text(
            modifier = Modifier.padding(vertical = 12.dp),
            text = "Start earning rewards and enjoying perks with the Starbucks app. Join today!",
            fontSize = 14.sp,
            textAlign = TextAlign.Justify
        )
        TextFieldInput(
            value = email,
            onValueChange = setEmail,
            labelText = "Email"
        )
        TextFieldInput(
            value = password,
            onValueChange = setPassword,
            labelText = "Password",
            visualTransformation =  PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val privacyText = "Privacy"
            val policyText = "Policy"

        }
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSignUpClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkGreen
            )
        ) {
            Text(text = "Register")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account?",
                fontSize = 14.sp
            )
            TextButton(onClick = onSignInClick) {
                Text(
                    text = "Sign In",
                    color = DarkGreen,
                    fontSize = 14.sp
                )
            }
        }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SignUpScreenPreview() {
        SignUpScreen({}, {})

}