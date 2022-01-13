<?php 

//if($_SERVER['REQUEST_METHOD'] == "POST"){
//GetData
    $userName = isset($_POST['userName'])? $_POST['userName'] : "";
    $fullName = isset($_POST['fullName'])? $_POST['fullName'] : "";
    $phoneNum = isset($_POST['phoneNum'])? $_POST['phoneNum'] : "";
        
    $server_name = "localhost";
	$username = "root";
	$password = "";
	$dbname = "hotel";

    $conn = new mysqli($server_name,$username,$password,$dbname);

    if($conn->connect_error){
        die("Connection failed: " . $conn->connect_error);
    }else{
        echo "Success";
    }

    
    $sql = "insert into customer values($userName, $fullName, $phoneNum, null);";
    
    if($conn->query($sql)===TRUE){
        echo "Succ";
    }else{
        echo "Erorr";
    }


$conn->close(); 

//}








?>