<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Admin</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/fullcalendar.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/matrix-style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/matrix-media.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/font-awesome.css"/>
        <link rel="stylesheet" href="<c:url value="/webjars/font-awesome/4.6.2/css/font-awesome.css"/>"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/jquery.gritter.css" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    </head>
    <body>

        <!--Header-part-->
        <div id="header">
            <h1><a href="dashboard.html">Matrix Admin</a></h1>
        </div>

        <!--top-Header-menu-->
        <jsp:include page="../include/topMenuAdmin.jsp"/>


        <!--sidebar-menu-->
        <jsp:include page="../include/slidebarMenuAdmin.jsp"/>

        <div id="content">
            <div id="content-header">
                <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="tip-bottom">Form elements</a> <a href="#" class="current">Common elements</a> </div>
                <h1>Common Form Elements</h1>
            </div>
            <div class="container-fluid">
                <hr>
                <div class="row-fluid "> 
                    <div class="span3"></div>
                    <div class="span6 align-self-center">
                        <div class="widget-box">
                            <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
                                <h5>Personal-info</h5>
                            </div>
                            <div class="widget-content nopadding">
                                <mvc:form action="${pageContext.request.contextPath}/admin/${action}" method="post" class="form-horizontal" modelAttribute="product" enctype="multipart/form-data">
                                    <div class="control-group">
                                        <label class="control-label" >Product Name :</label>
                                        <div class="controls">
                                            <input type="text" class="span11" name="name" placeholder="First name" />
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Price :</label>
                                        <div class="controls">
                                            <input type="text" class="span11" name="price" placeholder="Price" />
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Category :</label>
                                        <div class="controls">
                                            <select name="category.id" class="form-control">
                                                <c:forEach var="c" items="${categories}">             
                                                    <option value="${c.id}">${c.name}</option>                      
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Status :</label>
                                        <div class="controls">
                                            <input type="text" class="span11" name="status" value="true" />
                                        </div>
                                    </div>    
                                    <div class="control-group">
                                        <label class="control-label">Size :</label>
                                        <div class="controls">
                                            <c:forEach var="s" items="${sizes}">
                                                <label>
                                                    <input type="checkbox" name="sizeTemp" value="${s.id}"/>
                                                ${s.size}
                                                </label>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Image :</label>
                                        <div class="controls">
                                            <input type="file" name="file"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Image Small :</label>
                                        <div class="controls">
                                            <input type="file" name="file"/>
                                        </div>
                                    </div>
                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-success">Save</button>
                                    </div>
                                </mvc:form>
                            </div>
                        </div>

                    </div>

                </div>

            </div></div>

        <jsp:include page="../include/footerAdmin.jsp"/>


        <!--end-Footer-part-->

        <script src="resource/admin/js/excanvas.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.ui.custom.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/bootstrap.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.flot.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.flot.resize.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.peity.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/fullcalendar.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/matrix.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/matrix.dashboard.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.gritter.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/matrix.interface.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/matrix.chat.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.validate.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/matrix.form_validation.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.wizard.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.uniform.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/select2.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/matrix.popover.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.dataTables.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/matrix.tables.js"></script> 

        <script type="text/javascript">
            // This function is called from the pop-up menus to transfer to
            // a different page. Ignore if the value returned is a null string:
            function goPage(newURL) {

                // if url is empty, skip the menu dividers and reset the menu selection to default
                if (newURL != "") {

                    // if url is "-", it is this page -- reset the menu:
                    if (newURL == "-") {
                        resetMenu();
                    }
                    // else, send page to designated URL            
                    else {
                        document.location.href = newURL;
                    }
                }
            }

            // resets the menu selection upon entry to this page:
            function resetMenu() {
                document.gomenu.selector.selectedIndex = 2;
            }
        </script>
    </body>
</html>
