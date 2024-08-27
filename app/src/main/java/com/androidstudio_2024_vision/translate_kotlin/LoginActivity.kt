package com.androidstudio_2024_vision.translate_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val username: EditText =findViewById(R.id.et_account)
        val pwd:EditText=findViewById(R.id.et_password)
        val login: Button =findViewById(R.id.login)
        login.setOnClickListener{

            val str_name=username.text.toString()
            val str_pwd=pwd.text.toString()
//          判断输入是否正确
            if (str_name.isEmpty()){
                username.setError("手机号不能为空")
            }
            if (str_pwd.isEmpty()){
                pwd.setError("密码不能为空")
            }

//          登录成功，进入主页
            if (str_name.equals("13456789028") && str_pwd.equals("aaaa12")){
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }

        //        还未注册？去注册
        val register: TextView =findViewById(R.id.register)
        register.setOnClickListener{
            val intent=Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        //进入主界面
//        val homepage: Button =findViewById(R.id.login)
//        homepage.setOnClickListener{
//            val intent=Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }
    }
}