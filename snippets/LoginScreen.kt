package com.example.myfirstapp

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.security.KeyStore.TrustedCertificateEntry

@Composable
fun LoginScreen() {
    var userName by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    var keepSignedIn by remember { mutableStateOf(false) }

    val transition = rememberInfiniteTransition()
    val logoScale by transition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val gradientPosition by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing)
        )
    )
    val socialButtonScale by transition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val bounceEffect by transition.animateFloat(
        initialValue = 0f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val signUpTextColor by transition.animateColor(
        initialValue = Color.White,
        targetValue = Color(0xFF6A11CB),
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(colors = listOf(
                    Color(0xFF1A1A2E),
                    Color(0xFF0F0C29)
                ))
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White.copy(alpha = 0.1f))
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .graphicsLayer { scaleX = logoScale; scaleY = logoScale }
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painterResource(id = android.R.drawable.ic_menu_compass),
                        contentDescription = "App Logo",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Text(
                    text = "Welcome Back!",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Sign in to Continue",
                    color = Color.LightGray,
                    fontSize = 16.sp
                )

                OutlinedTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Username", color = Color.White.copy(alpha = 0.7f))
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Username logo"
                        )
                    },
                    colors = glassTextFieldColors(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )

                OutlinedTextField(
                    value = userPassword,
                    onValueChange = { userPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Password", color = Color.White.copy(alpha = 0.7f))
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = "Password logo"
                        )
                    },
                    colors = glassTextFieldColors(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Icon(
                            Icons.Default.ThumbUp,
                            contentDescription = "Keep Signed in",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(24.dp)
                                .offset(y = bounceEffect.dp)
                                .background(
                                    brush = Brush.radialGradient(
                                        colors = listOf(Color(0xFF2575FC),Color(0xFF6A11CB))
                                    ),
                                    shape = CircleShape
                                )
                                .padding(4.dp)
                        )

                        Text(
                            text = "Remember Me",
                            color = Color.White,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    Switch(
                        checked = keepSignedIn,
                        onCheckedChange = { keepSignedIn = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color(0xFF6A11CB),
                            uncheckedThumbColor = Color.LightGray,
                            uncheckedTrackColor = Color.DarkGray
                        )
                    )
                }


                TextButton(
                    onClick = { /* Handle Logic Here*/ },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Forgot Password?",
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }

                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.Transparent),
                    contentPadding = PaddingValues()

                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xFF2575FC),Color(0xFF6A11CB)
                                    ),
                                    startX = gradientPosition
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("LOGIN", color = Color.White, fontWeight = FontWeight.Bold)

                            Icon(
                                Icons.Default.ArrowForward,
                                contentDescription = "Login",
                                tint = Color.White,
                                modifier = Modifier.padding(start = 8.dp)
                            )

                        }
                    }
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SocialButton("G",socialButtonScale) { }
                    Spacer(modifier = Modifier.width(20.dp))
                    SocialButton("f", socialButtonScale) { }
                }

                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Don't have an account?",
                        color = Color.LightGray
                    )

                    Text(
                        text = "Sign Up",
                        color = signUpTextColor,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {}
                    )

                }

            }
        }
    }


}

@Composable
fun SocialButton(symbol: String, scale: Float, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .graphicsLayer { scaleX = scale; scaleY = scale }
            .border(1.dp, Color.White.copy(alpha = 0.3f), CircleShape)
    ) {
        Text(
            text = symbol,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun glassTextFieldColors(): TextFieldColors {
    val infiniteTransition = rememberInfiniteTransition()

    // Animate border shimmer between two alpha levels
    val animatedBorderColor by infiniteTransition.animateColor(
        initialValue = Color.White.copy(alpha = 0.6f),
        targetValue = Color.White.copy(alpha = 0.9f),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Animate label color gently to give breathing motion
    val animatedLabelColor by infiniteTransition.animateColor(
        initialValue = Color.White.copy(alpha = 0.6f),
        targetValue = Color.White.copy(alpha = 0.8f),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    return OutlinedTextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,

        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        cursorColor = Color.White,

        // Animated border shimmer effect
        focusedBorderColor = animatedBorderColor,
        unfocusedBorderColor = Color.White.copy(alpha = 0.5f),

        // Animated label breathing effect
        focusedLabelColor = animatedLabelColor,
        unfocusedLabelColor = Color.White.copy(alpha = 0.7f),

        // Icons and placeholders remain steady
        focusedLeadingIconColor = Color.White.copy(alpha = 0.9f),
        unfocusedLeadingIconColor = Color.White.copy(alpha = 0.7f),
        focusedPlaceholderColor = Color.White.copy(alpha = 0.7f),
        unfocusedPlaceholderColor = Color.White.copy(alpha = 0.7f)
    )
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
