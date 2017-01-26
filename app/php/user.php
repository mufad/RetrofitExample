<?php 
    $servername = "mysql1002.mochahost.com";
    $username = "sakib777_dd";
    $password = "100%safe";
    $db_name="sakib777_test";


    // Create connection
    $conn = new mysqli($servername, $username, $password, $db_name);

    // Check connection

    if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
    }else{
        //echo "Connection Successful";
   }

    if ($_SERVER['REQUEST_METHOD'] === 'POST'){
    $data=file_get_contents('php://input');
    $json_data = json_decode($data , true);

    $email=$json_data['email'];
    $passwords=$json_data['password'];
   

     $sql = "SELECT name FROM user_info WHERE email='$email' and password='$passwords'";
     $result = mysqli_query($conn, $sql);
    if($row=mysqli_fetch_assoc($result)){
       $name= $row[name];
       $response = array('status' => true, 'message' => $name);
    }else{
       $response = array('status' => true, 'message' => 'QUERY ERROR');
   }
    
    echo json_encode($response);
    $conn->close();
}
?>