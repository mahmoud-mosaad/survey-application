<%@page import="Model.SuspendedUserResponse"%>
<%@page import="Model.AdminMsg"%>
<%@page import="Model.Spam"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Survey"%>
<%@page import="Model.User"%>
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
            if (currentUser.isSuspended() == 1) {
                response.sendRedirect("SignOut");
            }

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>
        <link rel='stylesheet' href='css\bootstrap.min.css'/>
        <link rel='stylesheet' href='css\profile.css'/>
        <title>Profile</title>
    </head>
    <body>



        <%           Spam spam1 = new Spam();
            ArrayList<Spam> spamSurveys = new ArrayList<Spam>();
            spamSurveys = spam1.getSpamedSurveysByCount();
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

                    <li class='nav-item active'>
                        <a class='nav-link' data-toggle="tooltip" title="Profile" href='#'>Profile</a>
                    </li>

                    <li class='nav-item'>
                        
                        <a class='nav-link' data-toggle="tooltip" title="my Panel" href='UserPanel.jsp'>My Panel</a>
                    </li>
                    <%
                        if(currentUser.getType()==1){
                    %>
                    <li class='nav-item'>
                        <a class='nav-link' data-toggle="tooltip" title="my Panel" href='AdminPage.jsp'>Admin Panel</a>
                    </li>
                    <%}%>

                    <%
                        if (currentUser.getType() == 1) {
                    %>
                    <li class='nav-item dropdown'>
                        <a class='nav-link dropdown-toggle' href='#' id='navbarDropdown' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>
                            Notifications
                        </a>
                        <div class='dropdown-menu' aria-labelledby='navbarDropdown' style="width: 238px;">
                            <table>

                                <tr style="text-align: center;">
                                    <th style="padding: 0px 12px;">survey Name</th>
                                    <th style="padding: 0px 12px;">spam count</th>
                                </tr>

                                <%
                                    for (int ii = 0; ii < spamSurveys.size(); ii++) {
                                        Survey survey = new Survey();
                                        survey = survey.getSurvey(spamSurveys.get(ii).getSurveyID());
                                %>

                                <tr>
                                    <th style="padding: 0px 12px;">
                                        <form action="Survey.jsp?spammedSurveyNumber=<%= ii%>" method="POST">
                                            <input class='dropdown-item' type="submit" data-surveyid="<%= spamSurveys.get(ii).getSurveyID()%>" value="<%=survey.getName()%>"/>   
                                            <input name='surveyID-<%= ii%>' value="<%= spamSurveys.get(ii).getSurveyID()%>" type="text" hidden="true"/>
                                           
                                            <input name='useridd-<%= ii%>' value="<%= currentUser.getId()%>" type="text" hidden="true"/>
                                        </form>
                                    </th>
                                    <th style="text-align: center; padding: 0px 12px;"><%= spamSurveys.get(ii).getSpamCount()%></th>
                                </tr>


                                <%}%>

                            </table>
                        </div>
                    </li>
                    <%}%>

                </ul>


                <form action="SignOut" method="POST">
                    <input class="btn btn-outline-secondary sign-out-button" style="box-shadow:none;" type="submit" value="Sign-Out">
                </form>
            </div>
        </nav>

        <!--End of Nav Bar-->

        <!-- Profile Start -->

        <div class="row " style="margin: 7% auto;" >

            <div class="Sign_Up_Form col-lg-4">
                <form action="ProfileManager" method="POST">
                    <div class="form-group">
                        <label>Name :  </label>
                        <span><%= currentUser.getName()%></span> 
                    </div>

                    <div class="form-group">
                        <label>E-mail :  </label>
                        <span><%= currentUser.getEmail()%></span>
                    </div>

                    <label>Change Password!</label>
                    <div class="form-group">
                        <input type="password" class="form-control" name="userCurrentPassword" id="userCurrentPassword" placeholder="Enter your Current Password" required="true">
                        <small id="currentPasswordAuth" class="form-text invalid-feedback error"></small>
                    </div>

                    <div class="form-group">
                        <input type="password" class="form-control" name="userNewPassword" id="userNewPassword" placeholder="Enter your New Password" required="true">
                        <small id="newPasswordAuth" class="form-text invalid-feedback error"></small>
                    </div>

                    <div class="form-group">
                        <label>Age :  </label>
                        <span><%= currentUser.getAge()%></span>
                    </div>

                    <div>


                        <div class="form-group">
                            <label>Gender :  </label>
                            <span><%= currentUser.getGender()%></span>
                        </div>

                    </div>
                    <input id="sign_up_button"  type="submit" class="btn btn-primary Sign_Up_Button" value="Save Changes" style="box-shadow: none;"/>
                    <div class="clear"></div> 
                </form>
            </div>

            <div class="col-lg-4 msg-box" style="overflow-y: scroll">
                <div style="text-align: center">Admin Messages</div>
                <%
                    AdminMsg adminMsg = new AdminMsg();
                    ArrayList<AdminMsg> adminmsgs = new ArrayList<AdminMsg>();
                    adminmsgs = adminMsg.getAdminMsgs();
                    for (int iii = 0; iii < adminmsgs.size(); iii++) {
                        if (currentUser.getId().equals(adminmsgs.get(iii).getUserID())) {


                %>

                <div class="alert alert-primary" role="alert">
                    <%=adminmsgs.get(iii).getMsg()%>
                </div>
                <%}
    }%>
    
    
    <%
                    SuspendedUserResponse res = new SuspendedUserResponse();
                    ArrayList<SuspendedUserResponse> ress = new ArrayList<SuspendedUserResponse>();
                    ress = res.getAdminMsgs();
                    for (int iii = 0; iii < ress.size(); iii++) {
                        
                    User u = new User();
                    u = u.getUserByID(ress.get(iii).getUserID());

                %>

                <div class="alert alert-warning" role="alert">
                    <%= u.getEmail()%>
                    <br>
                    <%=ress.get(iii).getMsg()%>
                </div>
                <%
    }%>
    
            </div>

        </div>

        <!-- Profile End -->
        <%}%>
        <script type='text/javascript' src='js\jQuery.js'></script>
        <script type='text/javascript' src='js\popper.js'></script>
        <script type='text/javascript' src='js\bootstrap.js'></script>
        <script type='text/javascript' src='js\profile.js'></script>
    </body>
</html>
