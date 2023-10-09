package com.the.coso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the.coso.ui.theme.CoSoTheme

@Composable
fun TermsScreen(navController: NavController){
    CoSoTheme {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)) {
           item {
               AppBar("terms of use",navController)
               Spacer(modifier = Modifier.height(15.dp))
               Text("UniVerse Social Media App - Terms of Use\n" +
                       "\n" +
                       "\n" +
                       "Welcome to UniVerse! Please read these Terms of Use carefully before using our social media app. By accessing or using UniVerse, you agree to be bound by these Terms of Use. If you do not agree to these terms, please do not use UniVerse.\n" +
                       "\n" +
                       "1. Acceptance of Terms\n" +
                       "\n" +
                       "By using UniVerse, you agree to comply with and be bound by these Terms of Use. UniVerse may update these terms from time to time, and you are responsible for reviewing and becoming familiar with any changes. Your continued use of UniVerse after any modifications to these terms will constitute your acceptance of such changes.\n" +
                       "\n" +
                       "2. Eligibility\n" +
                       "\n" +
                       "You must be at least 13 years old to use UniVerse. By using UniVerse, you represent and warrant that you are at least 13 years old and have the capacity to enter into a legally binding agreement.\n" +
                       "\n" +
                       "3. Account Registration\n" +
                       "\n" +
                       "To use certain features of UniVerse, you may be required to create an account. You agree to provide accurate and complete information during the registration process and to keep your account information up to date. You are responsible for maintaining the security of your account and password.\n" +
                       "\n" +
                       "4. Content and Conduct\n" +
                       "\n" +
                       "a. User Content**: You are solely responsible for any content you post, upload, or otherwise make available on UniVerse. You retain ownership of your content, but by using UniVerse, you grant UniVerse a non-exclusive, worldwide, royalty-free, sublicensable, and transferable license to use, reproduce, distribute, prepare derivative works of, display, and perform your content in connection with the operation of UniVerse.\n" +
                       "\n" +
                       "b. Prohibited Content**: You may not post or share content that is illegal, harmful, threatening, abusive, harassing, defamatory, obscene, invasive of privacy, or otherwise objectionable. UniVerse reserves the right to remove or disable any content that violates these terms.\n" +
                       "\n" +
                       "c. Conduct: You agree not to engage in any behavior that disrupts or interferes with the operation of UniVerse or the experience of other users. This includes, but is not limited to, spamming, hacking, or using UniVerse for any unlawful purpose.\n" +
                       "\n" +
                       "5. Privacy\n" +
                       "\n" +
                       "Your use of UniVerse is subject to our Privacy Policy, which explains how we collect, use, and disclose information from and about you. By using UniVerse, you consent to the practices described in the Privacy Policy.\n" +
                       "\n" +
                       "6. Termination\n" +
                       "\n" +
                       "UniVerse reserves the right to terminate or suspend your account and access to UniVerse at our sole discretion, with or without cause and without notice.\n" +
                       "\n" +
                       "7. Disclaimers\n" +
                       "\n" +
                       "a. No Warranty**: UniVerse is provided \"as is\" and \"as available\" without any warranties of any kind, whether express or implied.\n" +
                       "\n" +
                       "b. Limitation of Liability**: To the fullest extent permitted by law, UniVerse and its affiliates shall not be liable for any indirect, incidental, special, consequential, or punitive damages, or any loss of profits or revenues.\n" +
                       "\n" +
                       "8. Indemnification\n" +
                       "\n" +
                       "You agree to indemnify and hold UniVerse and its affiliates, officers, agents, and employees harmless from any claims, liabilities, damages, or expenses arising out of your use of UniVerse, your violation of these Terms of Use, or your violation of any rights of another.\n" +
                       "\n" +
                       "9. Governing Law\n" +
                       "\n" +
                       "These Terms of Use are governed by and construed in accordance with the laws of [Jurisdiction]. Any disputes arising from or relating to UniVerse shall be subject to the exclusive jurisdiction of the courts located within [Jurisdiction].\n" +
                       "\n" +
                       "**10. Contact Us\n" +
                       "\n" +
                       "If you have any questions about these Terms of Use, please contact us at [Contact Email].\n" +
                       "\n" +
                       "By using UniVerse, you acknowledge that you have read, understood, and agree to be bound by these Terms of Use. Thank you for using UniVerse!")
           }
        }
    }
}


@Preview
@Composable
fun PrevTerms(){
    TermsScreen(rememberNavController())
}