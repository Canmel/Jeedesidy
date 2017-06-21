<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-10">
	<h4>用户信息管理</h4><hr/>
	<form class="form-horizontal tasi-form" method="post" ng-submit="processForm()" name="userForm" novalidate>
		<input type="hidden" ng-modle="user.id">
		<div class="form-group">
			<label class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name='name' ng-model="user.name" required >
				<p ng-show="userForm.name.$invalid && !userForm.name.$pristine" class="help-block">请输入姓名.</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">年龄</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" name="age" ng-model="user.age" required>
				<p ng-show="userForm.age.$error.pattern" class="help-block">.</p>
				<p ng-show="userForm.age.$invalid && !userForm.age.$pristine" class="help-block">请输入年龄.</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">手机</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="phone" ng-model="user.phone" required ng-pattern="/^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/" ng-minlength="11" ng-maxlength="11">
				<p ng-show="userForm.phone.$error.minlength" class="help-block">手机号长度过短.</p>
				<p ng-show="userForm.phone.$error.maxlength" class="help-block">手机号长度过长.</p>
				<p ng-show="userForm.phone.$error.pattern" class="help-block">请输入正确的11位手机号码.</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">备注</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" ng-model="user.remark">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">角色</label>
			<div class="col-sm-10">
				<div style="display: inline-flex; margin: 5px;" ng-repeat="v in allRole">
					<input type="checkbox" class="checkbox" name="role_ids" value="{{v.id}}" ng-checked="isSelected(v.id)">
					<label><span style="line-height: 30px;">{{v.name}}</span></label>
				</div>
			</div>
		</div>
		<div class="text-center">
			<button type="submit" ng-disabled="userForm.$invalid" class="btn btn-info">保存</button>
			<button type="button" class="btn btn-default" ui-sref="user">返回</button>			
		</div>
	</form>
</div>