	<%@taglib uri="/struts-tags" prefix="s"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
	
	<div class="container-fluid bg-0 text-center">

	
	  <div class="row">
	  
	  
		
	    
	    <form action="${pageContext.request.contextPath}/login" method="POST" class="col s6 offset-s4">
	   
	    <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					
	    <div class="row"> 
	    	 <div class="card-panel grey lighten-5 grey-text col s3 offset-s3">Log in</div>
	    </div>
	    
	    <c:if test="${not empty param.error}">
			<div class="alert alert-danger myalert">
			  <strong>Error !</strong> incorrect username or password
			</div>
		</c:if>
		<c:if test="${not empty param.logout}">
			<div class="alert alert-info myalert">
			   Logged out successfully
			</div>
		</c:if>
	    
	      <div class="row">
	        <div class="input-field col s8 ">
	          <i class="material-icons prefix">account_circle</i>
	          <input type="text" id= "username" name="username" required="required" Class="validate input-1" />
	          <label for="username">username</label>
	        </div>
	       
	      </div>
	      <div class="row">
	        <div class="input-field col s8 ">
	          <i class="material-icons prefix">lock_outline</i>
	          <input type="password"  id ="password" name="password" required="required" Class="validate input-1" />

	          <label for="password">password</label>
	        </div>
	        
	      
	      </div>
	      
	      <div class="row">
	      	
	      	 
	      
		      <button class="btn waves-effect waves-light col s3 offset-s3" type="submit" name="action">Submit
			    <i class="material-icons ">send</i>
			  </button>
	      </div>
	      
	    </form>
	  </div>
        
	

	</div>	