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
fun PrivacyPolicyScreen(navController: NavController){
    CoSoTheme {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)) {
            item {
                AppBar("privacy policy",navController)
                Spacer(modifier = Modifier.height(25.dp))
                Text("Welcome to UniVerse, a social media application dedicated to connecting people, sharing experiences, and fostering meaningful connections. At UniVerse, we understand the importance of your privacy and are committed to protecting your personal information. This Privacy Policy explains how we collect, use, disclose, and safeguard your data when you use our application and services (\"Services\"). By using UniVerse, you consent to the practices described in this policy.\n" +
                        "\n" +
                        "1. Information We Collect\n" +
                        "\n" +
                        "We collect the following types of information when you use UniVerse:\n" +
                        "\n" +
                        "1.1. Personal Information: This includes information you provide during registration, such as your name, email address, phone number, profile picture, and other profile details.\n" +
                        "\n" +
                        "1.2. Content: Any content you create, share, or post on UniVerse, including text, photos, videos, and other media.\n" +
                        "\n" +
                        "1.3. Usage Information: We collect information about how you use UniVerse, such as your interactions with other users, content you view, and the duration and frequency of your use.\n" +
                        "\n" +
                        "1.4. Device Information: We gather information about the devices you use to access UniVerse, including your device type, operating system, and unique device identifiers.\n" +
                        "\n" +
                        "1.5. Location Information: If you enable location services, we may collect your device's precise location data to provide location-based features.\n" +
                        "\n" +
                        "2. How We Use Your Information\n" +
                        "\n" +
                        "We use your information for various purposes, including:\n" +
                        "\n" +
                        "2.1. Providing and Improving Our Services: We use your data to deliver UniVerse's features, personalize content, and enhance the user experience.\n" +
                        "\n" +
                        "2.2. Communication: We may send you notifications, updates, and service-related messages to keep you informed about UniVerse and its features.\n" +
                        "\n" +
                        "2.3. User Support: We use your information to respond to your queries, requests, and provide technical support.\n" +
                        "\n" +
                        "2.4. Research and Analytics: We analyze user data to improve UniVerse's functionality, content, and user experience.\n" +
                        "\n" +
                        "2.5. Legal Compliance: We may use your information to comply with legal obligations and resolve disputes.\n" +
                        "\n" +
                        "3. Information Sharing\n" +
                        "\n" +
                        "We may share your information in the following circumstances:\n" +
                        "\n" +
                        "3.1. With Other Users: Certain information, such as your username and profile picture, may be visible to other UniVerse users. Content you post or share is also visible to other users based on your privacy settings.\n" +
                        "\n" +
                        "3.2. Service Providers: We may engage third-party service providers to help us operate and maintain UniVerse. These providers may have access to your information for specific purposes related to UniVerse's services.\n" +
                        "\n" +
                        "3.3. Legal Requirements: We may disclose your information when required by law or in response to valid legal requests, such as subpoenas or court orders.\n" +
                        "\n" +
                        "3.4. Safety and Security: We may share information to protect the safety, security, and rights of UniVerse, its users, and others.\n" +
                        "\n" +
                        "4. Your Choices\n" +
                        "\n" +
                        "You have control over your information on UniVerse:\n" +
                        "\n" +
                        "4.1. Account Settings: You can update your profile information and privacy settings within the UniVerse app.\n" +
                        "\n" +
                        "4.2. Data Access and Portability: You can request access to your data and export it from UniVerse.\n" +
                        "\n" +
                        "4.3. Account Deletion: You can delete your UniVerse account and associated data by contacting our support team.\n" +
                        "\n" +
                        "5. Security Measures\n" +
                        "\n" +
                        "We employ industry-standard security measures to protect your data against unauthorized access, disclosure, or alteration. However, no data transmission over the internet is entirely secure, so please use UniVerse with caution and follow best practices for online safety.\n" +
                        "\n" +
                        "6. Changes to this Policy\n" +
                        "\n" +
                        "UniVerse may update this Privacy Policy from time to time to reflect changes in our practices or legal requirements. We will notify you of significant updates through the UniVerse app or by email.\n" +
                        "\n" +
                        "7. Contact Us\n" +
                        "\n" +
                        "If you have any questions or concerns about this Privacy Policy or your data on UniVerse, please contact us at [Contact Email Address].\n" +
                        "\n" +
                        "Thank you for trusting UniVerse with your social connections. We are dedicated to protecting your privacy and providing a secure and enjoyable experience on our platform.")
            }
        }
    }
}

@Preview
@Composable
fun PrevPrivacy(){
    PrivacyPolicyScreen(rememberNavController())
}