
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt

class BiometricManage() {
fun authenticateWithBiometrics(context: AppCompatActivity){
    val biometricPrompt = BiometricPrompt(
        context,
        object :BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }


        }

    )
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Biometric Login")
        .setSubtitle("Sufyan Please Place your finger on the sensor")
        .setNegativeButtonText("Use Password")
        .build()

    biometricPrompt.authenticate(promptInfo)
}

}
