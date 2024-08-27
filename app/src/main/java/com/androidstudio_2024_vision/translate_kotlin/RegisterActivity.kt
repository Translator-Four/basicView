package com.androidstudio_2024_vision.translate_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        lateinit var dbHelper: DatabaseHelper
        val username: EditText =findViewById(R.id.register_user_name)
        val userphone : TextView = findViewById(R.id.register_phone)
        val pwd:EditText=findViewById(R.id.register_user_password)
        val confirm_pwd:EditText=findViewById(R.id.confirm_pwd)

//        验证，点击注册
        val register:TextView=findViewById(R.id.register_success)
        register.setOnClickListener{

            val str_phone=userphone.text.toString()
            val str_name = username.text.toString()
            val str_pwd=pwd.text.toString()
            val str_confirm_pwd=confirm_pwd.text.toString()

            //      手机号校验
            val userphone_regex:Regex= "[1][34578]\\d{9}".toRegex()
            //      密码校验:密码为6~16位数字,英文,符号至少两种组合的字符
            val pwd_regex:Regex="^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\\(\\)])+$)([^(0-9a-zA-Z)]|[\\(\\)]|[a-zA-Z]|[0-9]){6,16}$".toRegex()

            //        判断输入是否正确
            if (str_phone.isEmpty()){
                userphone.setError("手机号不能为空")
            } else if (str_phone.matches(userphone_regex)){

            }else{
                userphone.setError("请输入正确的手机号")
            }
            if (str_name.isEmpty()){
                username.setError("昵称不能为空")
            }
            if (str_pwd.isEmpty()){
                pwd.setError("密码不能为空")
            }else if (str_pwd.matches(pwd_regex)){

            }else{
                pwd.setError("密码为6~16位数字,英文,符号至少两种组合的字符")
            }
            if (str_confirm_pwd.isEmpty()){
                confirm_pwd.setError("确认密码不能为空")
            }
            if (!str_confirm_pwd.equals(str_pwd)){
                confirm_pwd.setError("两次密码必须保持一致")
            }
        }

        //  点击登录，跳转到登录页面
        val login: TextView =findViewById(R.id.login)
        login.setOnClickListener{
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}