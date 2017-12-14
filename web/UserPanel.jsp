<%@page import="Model.Survey"%>
<%@page import="Model.User"%>
<%@page import="Model.SurveyCounter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.SurveyAnswers"%>
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
            if (currentUser.getType() == 1) {
                response.sendRedirect("HomePage.jsp");
            } else {

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>
        <link rel='stylesheet' href='css\bootstrap.min.css'/>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/>
        <link rel='stylesheet' href='css\userPanel.css'/>
        <title>User Page</title>
        <script type='text/javascript' src='jQuery.js'></script>
    </head>
    <body>
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
                </ul>
                <form action="SignOut" method="POST">
                    <input class="btn btn-outline-secondary sign-out-button" style="box-shadow:none;" type="submit" value="Sign-Out">
                </form>
            </div>
        </nav>

        <!--End of Nav Bar-->


        <div id="accordion" role="tablist">

            <span>Name of survey</span>
            <span class="float-right"># of submission</span>
            <%
                SurveyCounter sc = new SurveyCounter();
                SurveyCounter sc1 = new SurveyCounter();
                Survey s = new Survey();
                ArrayList<SurveyCounter> surveyCounters = new ArrayList<SurveyCounter>();
                ArrayList<Survey> surveys = new ArrayList<Survey>();
                surveys = s.getSurveys();
                surveyCounters = sc.getSubmitedSurvey();
                for(int i=0 ; i<surveys.size() ; i++)
                {
                    int ii=0;
                    if(surveys.get(i).getUserID().equals(currentUser.getId()))
                    {
                        sc = sc.getSingleSubmitedSurveysCount(surveys.get(i).getId());
                        
            %>

            
            <div class="card">
                
                <div class="card-header row" role="tab" id="">
                    <div class="col-lg-11">
                    <h5 class="mb-0 collapse">
                        <a data-toggle="collapse" href="#collapseOne-<%=i%>" aria-expanded="true" aria-controls="collapseOne">
                            <%= surveys.get(i).getName()%>
                        </a>
                        <span class="float-right" style="color:blue">
                            
                          <%= sc.getSubmitedSurveyCount()%>
                            
                        </span> 
                    </h5>
                    </div>
                          <div class="col-lg-1">Suspend</div>
                </div>

                <div id="collapseOne-<%=i%>" class="collapse show" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                        <table class="padding display-inline">
                            
                            <tr id="table-row">
                                <th id="table-head">#</th>
                                <th id="table-head">User-Name</th>
                                <th id="table-head">Age</th>
                                <th id="table-head">Gender</th>
                            </tr>
                            
                            <%
                                for(int h=0 ; h<surveyCounters.size() ; h++)
                                {
                                    
                                    if(surveyCounters.get(h).getSurevyID().equals(surveys.get(i).getId()))
                                    {
                                        
                                    User user = new User();
                                    if(!surveyCounters.get(h).getUserID().equals("mina")){
                                    user = user.getUserByID(surveyCounters.get(h).getUserID());
                                    }
                                
                            %>
                            <tr>
                                <th id="table-head"><%= ++ii%></th>
                                <th id="table-head"><%= user.getName()%></th>
                                <th id="table-head"><%= user.getAge()%></th>
                                <th id="table-head"><%= user.getGender()%></th>
                            </tr>
                            
                            <%}}%>
                            
                        </table>
                            <img src="http://via.placeholder.com/500x150" class="img" style="vertical-align: top;">
                        <!--<div class="padding display-inline"></div>-->
                    </div>
                </div>
            </div>

            <%}}%>

        </div>


        <%}
            }%>


        <script type='text/javascript' src='jQuery.js'></script>
        <script type='text/javascript' src='popper.js'></script>
        <script type='text/javascript' src='bootstrap.js'></script>
        <script type='text/javascript' src='userPanel.js'></script>
    </body>
</html>
