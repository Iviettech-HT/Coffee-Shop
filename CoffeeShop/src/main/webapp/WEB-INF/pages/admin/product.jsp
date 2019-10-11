<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Matrix Admin</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/uniform.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/select2.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/matrix-style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/css/matrix-media.css" />
        <link href="${pageContext.request.contextPath}/resources-management/css/font-awesome.css" rel="stylesheet" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div id="header">
            <h1><a href="dashboard.html">Matrix Admin</a></h1>
        </div>

        <!--Header-part-->
        <jsp:include page="../include/topMenuAdmin.jsp"/>


        <!--sidebar-menu-->
        <jsp:include page="../include/slidebarMenuAdmin.jsp"/>
        
        <div id="content">
            <div id="content-header">
                <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Product</a> </div>
                <h1>Product</h1>
            </div>
            <div class="container-fluid">
                <hr>
                <div class="row-fluid">
                    <div class="span12">
                        <div class="widget-box">
                            <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
                                <h5>Data table</h5>
                            </div>
                            <div class="widget-content nopadding">
                                <table class="table table-bordered data-table">
                                    <thead>
                                        <tr>
                                            <th>Rendering engine</th>
                                            <th>Browser</th>
                                            <th>Platform(s)</th>
                                            <th>Engine version</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <tr class="gradeC">
                                            <td>Misc</td>
                                            <td>PSP browser</td>
                                            <td>PSP</td>
                                            <td class="center">-</td>
                                        </tr>
                                        <tr class="gradeU">
                                            <td>Other browsers</td>
                                            <td>All others</td>
                                            <td>-</td>
                                            <td class="center">-</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Footer-part-->
        <jsp:include page="../include/footerAdmin.jsp"/>
        <!--end-Footer-part-->
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.ui.custom.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/bootstrap.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.uniform.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/select2.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/jquery.dataTables.min.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/matrix.js"></script> 
        <script src="${pageContext.request.contextPath}/resources-management/js/matrix.tables.js"></script>
    </body>
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
</html>
