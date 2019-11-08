<script language="JavaScript">
function toggle(source) {
  checkboxes = document.getElementsByName('foo');
  for(var checkbox in checkboxes)
    checkbox.checked = source.checked;
}
</script>
   <h5> Order (<fmt:formatDate value="${s}" pattern="dd-MM-yyyy"/> to <fmt:formatDate value="${e}" pattern="dd-MM-yyyy"/>)</h5>
                           
<input type="checkbox" onClick="toggle(this)" /> Toggle All<br/>

<input type="checkbox" name="foo" value="bar1"> Bar 1<br/>
<input type="checkbox" name="foo" value="bar2"> Bar 2<br/>
<input type="checkbox" name="foo" value="bar3"> Bar 3<br/>
<input type="checkbox" name="foo" value="bar4"> Bar 4<br/>
<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Form Layout</h5>
        </div>
        <div class="widget-content">
          <div class="controls">
            <input type="text" placeholder=".span12" class="span12 m-wrap">
          </div>
          <div class="controls controls-row">
            <input type="text" placeholder=".span11" class="span11 m-wrap">
            <input type="text" placeholder=".span1" class="span1 m-wrap">
          </div>
          <div class="controls controls-row">
            <input type="text" placeholder=".span10" class="span10 m-wrap">
            <input type="text" placeholder=".span2" class="span2 m-wrap">
          </div>
          <div class="controls controls-row">
            <input type="text" placeholder=".span9" class="span9 m-wrap">
            <input type="text" placeholder=".span3" class="span3 m-wrap">
          </div>
          <div class="controls controls-row">
            <input type="text" placeholder=".span8" class="span8 m-wrap">
            <input type="text" placeholder=".span4" class="span4 m-wrap">
          </div>
          <div class="controls controls-row">
            <input type="text" placeholder=".span7" class="span7 m-wrap">
            <input type="text" placeholder=".span5" class="span5 m-wrap">
          </div>
          <div class="controls controls-row">
            <input type="text" placeholder=".span6" class="span6 m-wrap">
            <input type="text" placeholder=".span6" class="span6 m-wrap">
          </div>
          <div class="controls controls-row">
            <input type="text" placeholder=".span5" class="span5 m-wrap">
            <input type="text" placeholder=".span7" class="span7 m-wrap">
          </div>
         
          <div class="controls controls-row">
            <input type="text" placeholder=".span2" class="span2 m-wrap">
            <input type="text" placeholder=".span3" class="span3 m-wrap">
            <input type="text" placeholder=".span4" class="span4 m-wrap">
            <input type="text" placeholder=".span1" class="span2 m-wrap">
            <input type="text" placeholder=".span1" class="span1 m-wrap">
          </div>
        </div>
      </div>