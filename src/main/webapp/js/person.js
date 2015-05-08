$().ready(function() {
	loadData();
});

function loadData() {
	$.post("personAction_showPerson.action", null, function(data) {
		/**
		 * <tr>
		 * <th>pid</th>
		 * <th><input type="text" name="pname" value=""></th>
		 * <th><input type="text" name="psex" value=""></th>
		 * <th><a>删除</a></th>
		 * </tr>
		 */
		for (var i = 0; i < data.pList.length; i++) {
			var $TDpid = $("<td></td>");
			$TDpid.text(data.pList[i].pid);

			var $inputPNAME = $("<input/>");
			$inputPNAME.attr("type", "text");
			$inputPNAME.attr("name", "pname");
			$inputPNAME.attr("pid", data.pList[i].pid);
			$inputPNAME.attr("value", data.pList[i].pname);
			/*
			 * 用于修改inputPNAME内容后触发
			 * 	*/		
			$inputPNAME.change(function() {
				var pname = $(this).val();
				var pid = $(this).attr("pid")
				$.post("personAction_updatePerson.action", {
					pname : pname,
					pid : pid
				}, function(data) {
					alert("修改成功");
				});
			});
			var $TDpname = $("<td></td>");
			$TDpname.append($inputPNAME);

			var $inputPSex = $("<input/>");
			$inputPSex.attr("type", "text");
			$inputPSex.attr("name", "psex");
			$inputPSex.attr("pid", data.pList[i].pid);
			$inputPSex.attr("value", data.pList[i].psex);
			/*
			 * 用于修改inputPSex内容后触发
			 * 	*/	
			$inputPSex.change(function() {

				var psex = $(this).val();
				var pid = $(this).attr("pid")
				$.post("personAction_updatePerson.action", {
					psex : psex,
					pid : pid
				}, function(data) {
					alert("修改成功");
				});
			});
			var $TDpsex = $("<td></td>");
			$TDpsex.append($inputPSex);

			var $aDel = $("<a></a>");
			$aDel.attr("pid", data.pList[i].pid);
			$aDel.text("删除");
			$aDel.css("cursor", "pointer");
			/**
			 * 在回调函数执行完的时候才要触发该事件，所以回调函数中的参数在这里是不能使用的
			 */
			$aDel.click(function() {
				var id = $(this).attr("pid");
				var aObj = this;
				$.post("personAction_deletePerson.action", {
					pid : id
				}, function(data) {
					$(aObj).parent().parent().remove();
					alert("删除成功");
				});
			});
			var $aDelTd = $("<td></td>");
			$aDelTd.append($aDel);

			var $tr = $("<tr></tr>");
			$tr.append($TDpid);
			$tr.append($TDpname);
			$tr.append($TDpsex);
			$tr.append($aDelTd);

			$("table").append($tr);
		}
	});
}
