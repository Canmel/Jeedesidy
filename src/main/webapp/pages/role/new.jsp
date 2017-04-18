<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<div class="col-sm-10">
    <h4>角色信息管理</h4>
    <hr/>
    <form class="form-horizontal tasi-form" method="post" ng-submit="processForm()" name="RoleForm" novalidate>
        <input type="hidden" ng-modle="role.id">
        <div class="form-group">
            <label class="col-sm-2 control-label">角色名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name='name' ng-model="role.name" required>
                <p ng-show="RoleForm.name.$invalid && !RoleForm.name.$pristine" class="help-block">请输入角色名称.</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">备注</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="remark" ng-model="role.remark" required>
                <p ng-show="RoleForm.age.$error.pattern" class="help-block">.</p>
                <p ng-show="RoleForm.age.$invalid && !RoleForm.age.$pristine" class="help-block">请输入备注.</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">菜单</label>
            <div class="col-sm-10">
                <label  ng-repeat="v in allMenus">
                    <input type="checkbox" value="{{v.id}}" name="menu">{{v.name}}
                </label>
            </div>
        </div>
        <div class="text-center">
            <button type="submit" ng-disabled="RoleForm.$invalid" class="btn btn-info">保存</button>
            <button type="button" class="btn btn-default" ui-sref="role">返回</button>
        </div>
    </form>
</div>