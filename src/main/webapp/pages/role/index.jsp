<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="adv-table editable-table ">
	<h4>角色信息管理</h4>
	<hr/>
	<div class="panel-body">
		<div class="adv-table editable-table ">
			<div id="editable-sample_wrapper" class="dataTables_wrapper form-inline" role="grid">
				<div class="row text-right">
					<div>
						<label>角色名称</label>
						<input type="text" aria-controls="editable-sample" class="form-control medium" ng-model="searchParams.name">
						<button type="button" class="btn  btn-info left-space" ng-click="search()"><i class="fa fa-search"></i>查询</button>
						<a id="editable-sample_new" class="btn btn-success green" ui-sref="newRole"> <i class="fa fa-plus"></i>创建</a>
					</div>
				</div>
				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>
							<th><i class="fa fa-bullhorn"></i>角色名称</th>
							<th class="hidden-phone"><i class="fa fa-question-circle"></i>可用菜单</th>
							<th><i class="fa fa-bookmark"></i>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="v in datas">
							<td>{{v.name}}</td>
							<td class="hidden-phone">{{v.id}}</td>
							<td>{{v.id}}</td>
							<td>
								<button class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></button>
								<button class="btn btn-primary btn-xs" ui-sref="editRole({id:v.id})" ><i class="fa fa-pencil"></i></button>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="row">
					<div class="col-lg-6">
						<div>
							<div class="dataTables_paginate paging_bootstrap pagination">
								<ul>
									<li ng-if="searchParams.pindex == 1" class="prev disabled">
										<a>← Previous</a>
									</li>
									<li ng-if="searchParams.pindex > 1" class="prev">
										<a ng-click="pageQuery(searchParams.pindex - 1)">← Previous</a>
									</li>

									<li ng-if="searchParams.pindex > 1">
										<a ng-click="pageQuery(searchParams.pindex - 1)">{{searchParams.pindex - 1}}</a>
									</li>
									<li class="active">
										<a  ng-click="pageQuery(searchParams.pindex)">{{searchParams.pindex}}</a>
									</li>
									<li ng-if="searchParams.pindex < searchParams.ptotal">
										<a  ng-click="pageQuery(searchParams.pindex + 1)">{{searchParams.pindex + 1}}</a>
									</li>

									<li ng-if="searchParams.pindex == searchParams.ptotal" class="next disabled">
										<a>Next → </a>
									</li>
									<li ng-if="searchParams.pindex < searchParams.ptotal" class="next">
										<a ng-click="pageQuery(searchParams.pindex + 1)">Next → </a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>