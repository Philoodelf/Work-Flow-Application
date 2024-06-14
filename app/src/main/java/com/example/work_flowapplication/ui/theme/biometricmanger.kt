
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt

class BiometricManage() {
fun authenticateWithBiometrics(context: AppCompatActivity, onSuccess: () -> Unit){
    val biometricPrompt = BiometricPrompt(
        context,
        object :BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                onSuccess()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }


        }

    )
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Biometric Login")
        .setSubtitle("Sufyan Please Place your finger on the sensor")
        .setNegativeButtonText("use pin")
        .build()

    biometricPrompt.authenticate(promptInfo)
}

}
