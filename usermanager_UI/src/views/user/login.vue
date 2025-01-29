<template>
         <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
       
        class="demo-ruleForm"
        >
        <el-row type="flex" justify="center">
        <el-col :span="5">
            <el-form-item prop="username">
            <el-input
            type="text"
            placeholder="请输入用户名"
            required="required"
            v-model="ruleForm.username"
            prefix-icon="el-icon-user-solid"
            ></el-input>
            </el-form-item>
        </el-col>
        </el-row>
        <el-row type="flex" justify="center">
        <el-col :span="5">
            <el-form-item prop="password">
            <el-input
            type="password"
            placeholder="请输入密码"
            prefix-icon="el-icon-lock"
            v-model="ruleForm.password"
            ></el-input>
            </el-form-item>
        </el-col>
        </el-row>
        <el-row type="flex" justify="center">
        <el-col :span="5">
            <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
            </el-form-item>
        </el-col>
        </el-row>
    </el-form>
   
</template>

<script>
import axios from 'axios'
 export default {
    data() {
      return {
        ruleForm: {
          username: '',
          password: ''
        },
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            //TODO:向后台发送异步请求，携带请求数据完成登录
            let url="/user/loginServlet";
            //定义变量保存要传输的数据
            let params= `username=${this.ruleForm.username}&pwd=${this.ruleForm.password}`;
            //发送异步请求
            axios.post(url,params)
            .then(resp=>{
              if(resp.data){
                location.href="#/success";
              }else{
                this.$message.error('请输入正确的用户名或密码！');
                this.resetForm(formName);
              }
            })
          } else {
            //表单校验失败
            console.log('error submit!!');
            return false;
          }
        });
      }
    }
  }

</script>

<style>
 
</style>