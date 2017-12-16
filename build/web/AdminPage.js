
function mm($id)
{
    $msg = $('#admin-suspend-msg-'+$id).val();
    if($msg.length==0){
        if($("#admin-suspend-button-"+$id).text() != "Undo"){
        $("#admin-suspend-button-"+$id).attr("disabled","disabled");}
    }else{
        $("#admin-suspend-button-"+$id).removeAttr("disabled");
        
    }
}

function suspendManager($isSuspended , $id ,$mail)
{
    $msg = $('#admin-suspend-msg-'+$id).val();
    $id = '#admin-suspend-button-'+$id;
    
    
    if ($isSuspended == '1') {
        // not suspended
        
        var request = new XMLHttpRequest();
        request.open("GET", "AdminController?suspendUser=" + $mail + "&suspendMsg="+$msg, true);
        request.send();
        
        request.onreadystatechange = function ()
        {
            if (request.status === 200 && request.readyState === 4)
            {
                if(request.responseText === "ok"){
                    $($id).text('Undo');
//                    location.reload(); 
                }
            }
        };
        
        
    } else
    {
        // suspended
        
        
        var request = new XMLHttpRequest();
        request.open("GET", "AdminController?unSuspendUser=" + $mail, true);
        request.send();
        
        request.onreadystatechange = function ()
        {
            if (request.status === 200 && request.readyState === 4)
            {
                if(request.responseText === "ok"){
                    $($id).text('Suspend');
                    location.reload(); 
                }
            }
        };
    }
}

function makeAdmin($isAdmin ,$id ,$mail)
{
   
    $id = '#'+$id;
    
    if ($isAdmin == '1') {
        
        var request = new XMLHttpRequest();
        request.open("GET", "AdminController?makeAdmin=" + $mail, true);
        request.send();
        
        request.onreadystatechange = function ()
        {
            if (request.status === 200 && request.readyState === 4)
            {
                if(request.responseText === "ok"){
                    $($id).text('Undo');
                    location.reload(); 
                }
            }
        };
        
        
    } else
    {   
        var request = new XMLHttpRequest();
        request.open("GET", "AdminController?undoAdmin=" + $mail, true);
        request.send();
        
        request.onreadystatechange = function ()
        {
            if (request.status === 200 && request.readyState === 4)
            {
                if(request.responseText === "ok"){
                    $($id).text('Make Admin');
                    location.reload(); 
                }
            }
        };
    }
}

function sendMsg($email , $i , $userID)
{
        var msg = $('#admin-msg-'+$i).val();
        var request = new XMLHttpRequest();
        request.open("GET", "AdminController?adminMsg=" + msg +"&userID="+$userID+"&mail="+$email, true);
        request.send();
        
        request.onreadystatechange = function ()
        {
            if (request.status === 200 && request.readyState === 4)
            {
                if(request.responseText === "ok"){
                    $('#admin-msg-'+$i).val(""); 
                }
            }
        };
}


function sendMsgToAll()
{
        var msg = $('#admin-msg-all').val();
        var request = new XMLHttpRequest();
        request.open("GET", "AdminController?adminMsgAll=" + msg , true);
        request.send();
        
        request.onreadystatechange = function ()
        {
            if (request.status === 200 && request.readyState === 4)
            {
                if(request.responseText === "ok"){
                    $('#admin-msg-all').val(""); 
                }
            }
        };
}


        

        
