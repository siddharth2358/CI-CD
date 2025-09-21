const express = require("express")
const mongoose = require("mongoose")

mongoose.connect("mongodb://localhost:27017/logintest")
.then(()=>{
    console.log("mongodb connected successfully");
})
.catch(()=>{
    console.log("failed to connect");
})

const LoginSchema= new mongoose.Schema({
    name:{
        type:String,
        required:true
    },
    password:{
        type:String,
        required:true
    }
})


const collection=new mongoose.model("storedData",LoginSchema)

module.exports=collection

