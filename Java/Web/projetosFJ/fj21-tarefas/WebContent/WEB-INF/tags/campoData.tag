<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" %>

<input id="${id}" name="${id}" value="${value}"/>
<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>