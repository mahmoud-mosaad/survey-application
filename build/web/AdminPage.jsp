<%@page import="Model.Survey"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page import="Model.Spam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
    <%
            User currentUser = new User();
            session = request.getSession(false);
            if (session.getAttribute("currentUser") == null) {
                response.sendRedirect("SignIn.jsp");
            } else {
                currentUser = (User) session.getAttribute("currentUser");
                if(currentUser.getType()==0){response.sendRedirect("HomePage.jsp");}else{

        %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>
        <link rel='stylesheet' href='css\bootstrap.min.css'/>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/>
        <link rel='stylesheet' href='css\AdminPage.css'/>
        <title>Admin Page</title>
        <script type='text/javascript' src='jQuery.js'></script>
    </head>
    <body>

        <%
            Spam spam = new Spam();
            ArrayList<Spam> spamSurveys = new ArrayList<Spam>();
            spamSurveys = spam.getSpamedSurveysByCount();
        %>

        <!-- Start of Nav Bar -->
        <nav class='navbar navbar-expand-lg navbar-light bg-light'>
            <a class='navbar-brand logo' href='#'>HI, <%= currentUser.getName()%></a>
            <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#collapsedNav' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>
                <span class='navbar-toggler-icon'></span>
            </button>

            <div class='collapse navbar-collapse' id='collapsedNav'>
                <ul class='navbar-nav mr-auto'>

                    <li class='nav-item'>
                        <a class='nav-link' href='HomePage.jsp'>Home</a>
                    </li>

                    <li class='nav-item'>
                        <a class='nav-link' data-toggle="tooltip" title="Profile" href='Profile.jsp'>Profile</a>
                    </li>

                    <li class='nav-item active'>
                        <a class='nav-link' data-toggle="tooltip" title="Admin Panel" href='#'>My Panel</a>
                    </li>

                    <li class='nav-item dropdown'>
                        <a class='nav-link dropdown-toggle' href='#' id='navbarDropdown' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>
                            Notifications
                        </a>
                        <div class='dropdown-menu' aria-labelledby='navbarDropdown' style="width: 238px;">
                            <table>

                                <tr style="text-align: center;">
                                    <th>survey Name</th>
                                    <th>spam count</th>
                                </tr>

                                <%
                                    for (int ii = 0; ii < spamSurveys.size(); ii++) {
                                        Survey survey = new Survey();
                                        survey = survey.getSurvey(spamSurveys.get(ii).getSurveyID());
                                %>

                                <tr>
                                    <th><a class='dropdown-item' data-surveyid="<%= spamSurveys.get(ii).getSurveyID()%>" href='#'><%= survey.getName()%></a></th>
                                    <th style="text-align: center;"><%= spamSurveys.get(ii).getSpamCount()%></th>
                                </tr>


                           <%}%>
                           
                           </table>
                        </div>
                    </li>
                </ul>
                <button style="box-shadow:none;" class='btn btn-light my-2 my-sm-0 add-survey' onclick="location.href = 'AddSurvey.jsp';" id='border-raduis-0' type='button'>ADD SUREVEY</button>
                <form action="SignOut" method="POST">
                    <input class="btn btn-outline-secondary sign-out-button" style="box-shadow:none;" type="submit" value="Sign-Out">
                </form>
            </div>
        </nav>

        <!--End of Nav Bar-->

        <%
            User user = new User();
            int cc = 0;
            ArrayList<User> users = new ArrayList<User>();
            users = user.getUsers();
        %>

        <div class="form-group form-inline">
            <input type="text" class="form-control" name="" id="admin-msg-all"  placeholder="Enter your Msg here" style="border-radius: 0px; width: 90%">
            <button  class="btn btn-primary"  onclick="sendMsgToAll()" id="" style="border-radius: 0px; box-shadow: none">Go All</button>
        </div>

        <table class="users-table">
            <tr id="user-table-head">
                <th id="user-table-head-row">#</th>
                <th id="user-table-head-row">Name</th>
                <th id="user-table-head-row">Email</th>
                <th id="user-table-head-row">Change Password</th>
                <th id="user-table-head-row">Gender</th>
                <th id="user-table-head-row">Age</th>
                <th id="user-table-head-row">Type</th>
                <th id="user-table-head-row">Suspended!</th>
                <th id="user-table-head-row">State</th>
                <th id="user-table-head-row">Make Admin</th>
                <th id="user-table-head-row">Msg To</th>
            </tr>

            <%
                for (int i = 0; i < users.size(); i++) {
                   if(users.get(i).getId().equals(currentUser.getId())==false){
            %>

            <tr id="user-table-head">
                <th id="user-table-head-row"><%= cc++%></th>
                <th id="user-table-head-row"><%= users.get(i).getName()%></th>
                <th id="user-table-head-row"><%= users.get(i).getEmail()%></th>
                <th id="user-table-head-row">
                    <form action="AdminController" method="POST" class="form-inline">
                        <div class="form-group">
                            <input type="password" class="form-control" name="user-new-password" id="exampleInputEmail1"  placeholder="Enter New User Password" style="border-radius: 0px;">
                            <input type="text" class="form-control" name="user-email" hidden="true" id="user-id" value="<%= users.get(i).getEmail()%>" >
                            <small id="emailHelp" class="form-text" hidden="true"></small>
                        </div>
                        <input type="submit" class="btn btn-primary" value="Go" id="change-password-button" style="border-radius: 0px;">
                    </form> 
                </th>
                <th id="user-table-head-row"><%= users.get(i).getGender()%></th>
                <th id="user-table-head-row"><%= users.get(i).getAge()%></th>
                <th id="user-table-head-row"><%= users.get(i).getType()%></th>
                <th id="user-table-head-row">
                    <div class="input-group">
                    
                    <input type="text" class="form-control" placeholder="Send the reason of suspend" id="admin-suspend-msg-<%= i%>">
                    <button id="admin-suspend-button-<%= i%>"  onclick="suspendManager('<%= 1 - users.get(i).isSuspended()%>', <%= i%>, '<%= users.get(i).getEmail()%>')" type="button" class="btn btn-danger" style="cursor: pointer; box-shadow: none; border-radius: 0px">

                        <%
                            if (users.get(i).isSuspended() == 0) {
                                out.print("Suspend");
                            } else {
                                out.print("Undo");
                            }
                        %>
                    </button>
                    </div>
                </th>

                <th id="user-table-head-row">
                    <%
                        if (users.get(i).getState() == 0) {
                            out.print("offline");
                        } else {
                            out.print("<span style='color:#11e711'>online</span>");
                        }
                    %>

                </th>

                <th id="user-table-head-row">
                    <button id="make-admin-button-<%= i%>"  onclick="makeAdmin('<%= 1 - users.get(i).getType()%>', this.id, '<%= users.get(i).getEmail()%>')" type="button" class="btn btn-danger" style="cursor: pointer; box-shadow: none">

                        <%
                            if (users.get(i).getType() == 0) {
                                out.print("Make Admin");
                            } else {
                                out.print("Undo");
                            }
                        %>
                    </button>
                </th>

                <th id="user-table-head-row">
                    <div class="form-group form-inline" style="margin: auto;">
                        <input type="text" class="form-control" name="" id="admin-msg-<%= i%>"  placeholder="Enter your Msg here" style="border-radius: 0px;">
                        <button  class="btn btn-primary" onclick="sendMsg('<%= users.get(i).getEmail()%>', '<%= i%>', '<%= users.get(i).getId()%>')" id="change-password-button" style="border-radius: 0px; box-shadow: none">Go</button>
                    </div>
                </th>


            </tr>



            <%}}%>

        </table>



        <script type='text/javascript' src='popper.js'></script>
        <script type='text/javascript' src='bootstrap.js'></script>
        <script type='text/javascript' src='AdminPage.js'></script>
    </body>
    
    <%}}%>
</html>
