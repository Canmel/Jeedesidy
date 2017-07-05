<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-10">
	<h4>菜单信息管理</h4><hr/>
	<form class="form-horizontal tasi-form" method="post" ng-submit="processForm()">
		<input type="hidden" ng-modle="menu.id">
		<div class="form-group">
			<label class="col-sm-2 control-label">菜单名称</label>
			<div class="col-sm-10">
				<input class="form-control" id="name" type="text" required ng-model='menu.name' />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">菜单类型</label>
			<div class="col-sm-10">
				<select class="form-control" name="menuType_id" ng-model="menu.menuType_id">
					<option value="1">一级菜单</option>
					<option value="2">二级菜单</option>
				</select>
			</div>
		</div>
		<div class="form-group" ng-if="menu.menuType_id == 2">
			<label class="col-sm-2 control-label">菜单地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="resouce" ng-model="menu.resouce" required />
			</div>
		</div>
		<div class="form-group" ng-if="menu.menuType_id == 2">
			<label class="col-sm-2 control-label">父级菜单</label>
			<div class="col-sm-10">
				<select class="form-control" name="pid" ng-model="menu.pid">
					<option ng-repeat="tmenu in topMenus" value="{{tmenu.id}}">{{tmenu.name}}</option>
				</select>
			</div>
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-info">保存</button>
			<button type="button" class="btn btn-default" ui-sref="menu">返回</button>			
		</div>
	</form>
</div>