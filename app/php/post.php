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
      echo "Connection failed";
   }


  $sql="Select * from posts";
      $result = mysqli_query($conn, $sql);
      
      if($row=mysqli_fetch_assoc($result)){
            $response = array('status' => true, 'message' =>'QUERY SUCCESSFUL');
        }else{
            $response = array('status' => false, 'message' => 'QUERY ERROR');
        }
    
    echo json_encode($response);
    $conn->close();
?>
