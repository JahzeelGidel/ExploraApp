package com.jahzeelCubides.exploraapp

import android.util.Pair
import android.util.Patterns

//returner un true si es valido y un flase si no es valido
//tambien retorne una cadena que me diga que paso si no es valido

fun validateEmail(email: String): Pair<Boolean, String> {
    return when {
        email.length == 0 -> Pair(false, "El correo es obligatorio.")
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> Pair(false, "El correo es invalido.")

        else -> Pair(true, "")
    }
}

fun validatePassword(password: String): Pair<Boolean, String> {
    return when {
        password.length == 0 -> Pair(false, "El correo es obligatorio.")
        password.length < 6 -> Pair(false, "La contraseña debe tener al menos 6 caracteres.")
        else -> Pair(true, "")
    }
}



fun validateName(name: String): Pair<Boolean, String> {
    return when {
        name.length == 0 -> Pair(false, "El correo es obligatorio.")
        name.length < 3 -> Pair(false, "El nombre debe de contener mínimo 3 caracteres.")
        else -> Pair(true, "")
    }
}

fun validateConfirmPassword(password: String, confirmPassword: String): Pair<Boolean, String> =
    when {
        confirmPassword.length == 0 -> Pair(false, "El correo es obligatorio.")
        confirmPassword != password -> Pair(false, "Las contraseñas no coinciden.")
        else -> Pair(true, "")
    }



