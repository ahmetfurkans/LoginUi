package com.dag.odev2fmss

import android.content.Context
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat

class FormHelper {
    companion object {
        // Form item validate
        fun isFormEmpty(context: Context, username: Editable, password: Editable) {
            val isUserNameEmpty = username.isEmpty()
            val isPasswordEmpty = password.isEmpty()

            if (isPasswordEmpty ||
                isUserNameEmpty
            ) {
                Toast.makeText(context, "Username and Password not be empty", Toast.LENGTH_LONG)
                    .show()
            } else {
                if (username.toString().equals(User.USERNAME) && password.toString()
                        .equals(User.PASSWORD)
                ) {
                    Toast.makeText(context, "Welcome back $username", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "This user not exist", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Overloading Form item validate
        fun isFormEmpty(context: Context, username: Editable, password: Editable, email: Editable) {
            val isUserNameEmpty = username.isEmpty()
            val isPasswordEmpty = password.isEmpty()
            val isEmailEmpty = email.isEmpty()

            if (isPasswordEmpty ||
                isUserNameEmpty ||
                isEmailEmpty
            ) {
                Toast.makeText(context, "Username and Password not be empty", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(
                    context,
                    "Username: $username" +
                            " Password: $password Email: $email",
                    Toast.LENGTH_LONG,
                ).show()
            }
        }


        // Edit Text Error Color Change
        fun editTextTintChange(editText: EditText, context: Context) {
            val isEditTextEmpty = editText.text.isEmpty()

            if (isEditTextEmpty) {
                editText.background.setTint(ContextCompat.getColor(context, R.color.error))
            } else {
                editText.background.setTint(ContextCompat.getColor(context, R.color.black))
            }
        }
    }
}