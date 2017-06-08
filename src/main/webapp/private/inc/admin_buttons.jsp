<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-fluid bg-buttonn text-center" id="div"style="padding-top: 10px; padding-bottom: 10px;height: 95px;"><div  class="row">
			<div class="col-sm-4">
				<p>
				<div class="alert alert-success alert-dismissable" id="welcome" style="padding-top: 0px; padding-bottom: 0px; border-top-width: 0px;">
				  <a href="#" class="close" data-dismiss="alert" aria-label="close" style="padding-top: 6px; margin-top: 0px;">×</a>
				  <p><strong>Welcome</strong> Admin : ${user.login}</p>
				</div>
				</p>
			</div>
			<div class="col-sm-6">
				<button id="buttonU" type="button" class="btn btn-default">USERS</button>
				<button id="buttonR" type="button" class="btn btn-default">RESTAURANTS</button>
				<button type="button" class="btn btn-default">RESERVATIONS</button>
				<button type="button" class="btn btn-default">Default</button>
				
			</div>
			<div class="col-sm-2">
				<p></p>
			</div>
</div></div>