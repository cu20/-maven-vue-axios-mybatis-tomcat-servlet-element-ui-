<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="demo-ruleForm">
        <el-row type="flex" justify="center">
        <el-col :span="5">
            <el-form-item prop="username">
            <el-input type="text" placeholder="用户名" required="required" v-model="ruleForm.username" prefix-icon="el-icon-user-solid"></el-input>
            </el-form-item>
        </el-col>
        </el-row>
         <el-row type="flex" justify="center">
         <el-col :span="5">
            <el-form-item prop="password">
            <el-input type="password" placeholder="请输入密码" v-model="ruleForm.password" prefix-icon="el-icon-lock"></el-input>
            </el-form-item>
         </el-col>
         </el-row>
        <el-row type="flex" justify="center">
        <el-col :span="5">
            <el-form-item class="btn-form">
            <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
            <!-- <el-button @click="resetForm('ruleForm')">重置</el-button> -->
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
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            //TODO:向后台发送异步请求，携带请求数据完成注册
            let url="/user/registerServlet";
            let params= `username=${this.ruleForm.username}&pwd=${this.ruleForm.password}`;

            //发送异步请求
            axios.post(url,params)
            .then(
              resp=>{
                if(resp.data){
                  this.$message({
                  message: '恭喜你，账户创建成功',
                  type: 'success'
                })
              }else{
                this.$message.error('用户名已存在');
                this.resetForm(formName);
                
              }
              }

            );
          } else {
             //表单校验失败
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }


</script>
    
<style>

</style>