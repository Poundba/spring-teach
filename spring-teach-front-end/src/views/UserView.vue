<template>
  <div style="height: calc(100vh - 16px)">
    <el-container>
      <el-header style="display: flex;align-items: center">
        <el-button @click="add">添加用户</el-button>
      </el-header>
      <el-main style="height: calc(100vh - 16px - 60px - 60px)">
        <el-table :data="tableData" style="width: 100%">
          <el-table-column type="index"/>
          <el-table-column prop="username" label="用户名" width="180"/>
          <el-table-column label="性别" width="180">
            <template #default="scope">
              {{ scope.row.gender === "0" ? "女" : "男" }}
            </template>
          </el-table-column>
          <el-table-column prop="mobile" label="手机"/>
          <el-table-column prop="address" label="地址"/>
          <el-table-column label="操作">
            <template #default="scope">
              <el-button type="primary" @click="edit(scope.row.id)">修改</el-button>
              <el-button type="danger" @click="del(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-main>
      <el-footer style="display: flex;align-items: center">
        <!-- 分页 -->
        <el-pagination
            v-model:current-page="pagination.currentPage"
            v-model:page-size="pagination.pageSize"
            :page-sizes="[10, 20, 30, 50]"
            layout="total, sizes, prev, pager, next, jumper"
            :total="pagination.total"
            @size-change="this.init"
            @current-change="this.init"
        />
      </el-footer>
    </el-container>
  </div>

  <!-- 弹框 -->
  <el-dialog
      v-model="centerDialogVisible"
      title="添加/修改用户"
      width="500"
      align-center
  >
    <el-form :model="form" label-width="auto" style="max-width: 600px">
      <el-form-item label="用户名">
        <el-input v-model="form.username"/>
      </el-form-item>
      <el-form-item label="性别">
        <el-select
            v-model="form.gender"
            placeholder="去选择性别"
            size="large"
            style="width: 100%"
        >
          <el-option label="男" value="1"/>
          <el-option label="女" value="0"/>
        </el-select>
      </el-form-item>
      <el-form-item label="手机">
        <el-input v-model="form.mobile"/>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="form.address"/>
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveOrUpdate">
          添加/修改
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script>
import axios from "axios";
import {ElMessage} from "element-plus";

export default {
  data() {
    return {
      tableData: [],
      form: {
        username: '',
        gender: '',
        mobile: '',
        address: ''
      },
      pagination: {
        currentPage: 1,
        pageSize: 10,
        total: 0
      },
      centerDialogVisible: false
    }
  },
  methods: {
    init() {
      this.centerDialogVisible = false
      // axios.get('/api/user/page').then(res => {
      //   console.log(res)
      //   console.log(res.data.data)
      //   this.tableData = res.data.data
      // })

      console.log(this.pagination)

      axios.get(`/api/user/page?current=${this.pagination.currentPage}&size=${!this.pagination.pageSize ? 10 : this.pagination.pageSize}`).then(res => {
        console.log(res)
        this.tableData = res.data.data.records
        this.pagination.currentPage = res.data.data.current
        this.pagination.pageSize = res.data.data.size
        this.pagination.total = res.data.data.total
      })
    },
    add() {
      this.form = {
        username: '',
        gender: '',
        mobile: '',
        address: ''
      }

      this.centerDialogVisible = true
    },
    edit(id) {
      axios.get(`/api/user/${id}`).then(res => {
        this.form = res.data.data
      })

      this.centerDialogVisible = true
    },
    del(id) {
      axios.delete(`/api/user/${id}`).then(res => {
        ElMessage({
          message: `${res.data.msg}`,
          type: `${res.data.code === 200 ? "success" : "error"}`
        })
        this.init()
      })
    },
    saveOrUpdate() {
      axios.post('/api/user/saveOrUpdate', this.form).then(res => {
        console.log(res.data)
        ElMessage({
          message: `${res.data.msg}`,
          type: `${res.data.code === 200 ? "success" : "error"}`
        })
        this.init()
      })
    },
  },
  created() {
    this.init()
  }
}
</script>