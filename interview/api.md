# 同去活动列表api

笔试中用到API均不需认证，所以不需要登陆，请求时也不需要携带cookie

测试可以用chrome插件postman, 或者直接浏览器访问然后格式化json http://www.bejson.com/

## 活动列表

地址 http://tongqu.me/index.php/api/act/type

返回格式 json

示例

````
{
    "version": "1.0",
    "result": {
        "count": 4454,
        "acts": [
            {
                "actid": "9773",
                "name": "（电院专用）2015暑期社会实践导论课分论课选课信息登记",
                "type": "8",
                "location": "上海交通大学闵行校区",
                "poster_id": "5502",
                "team_id": "0",
                "source": "电院团委",
                "start_time": "2015-07-10 22:00",
                "end_time": "2015-07-10 22:10",
                "sign_start_time": "2015-07-03 12:00",
                "sign_end_time": "2015-07-10 20:00",
                "member_count": "782",
                "max_member": "0",
                "view_count": "5200",
                "comment_count": "0",
                "typename": "其他",
                "poster": "http://tongqu.me/upload/acts/20150629/small_69b9fbbb541a264922025c685bca7b45.png",
                "time_status": 1,
                "time_status_str": "正在报名"
            },
            {
                "actid": "9843",
                "name": "华为荣耀总裁赵明校园分享会",
                "type": "2",
                "location": "光彪楼一楼多功能厅",
                "poster_id": "5576",
                "team_id": "0",
                "source": "电院团委",
                "start_time": "2015-07-09 18:30",
                "end_time": "2015-07-09 20:00",
                "sign_start_time": "2015-07-03 17:28",
                "sign_end_time": "2015-07-09 17:28",
                "member_count": "320",
                "max_member": "500",
                "view_count": "3900",
                "comment_count": "8",
                "typename": "讲座",
                "poster": "http://tongqu.me/upload/acts/20150703/small_489eb2aa7d50c7cb89dd2e20c1a213cd.jpg",
                "time_status": 6,
                "time_status_str": "报名已结束"
            }
        ]
    },
    "opt": {
        "type_id": 0,
        "time_status": 0,
        "date_mode": 0,
        "date": null,
        "number": 2,
        "offset": 0,
        "team_id": 0,
        "poster": "small",
        "order": "hotvalue",
        "desc": "true",
        "school": "2002",
        "count": 4454
    },
    "error": 0,
    "msg": ""
}
````

- version api的版本, 暂时无用
- error 0 正常, 1 错误, 注意由于历史原因，有些错误请求仍会返回 http 200, 但是error值为1
- msg 一般为错误消息, 正确时大部分时间为空，但不要以它判断状态

### opt 请求的参数

TODO: 默认值

- type_id 活动的类型
- time_status 活动的时间状态
- number 数量
- offset 偏移
- order 排序
- desc 递减
- school 学校id 2002 为上海交大
- count 总共活动数量 (排除内部活动)

### result

TODO: other attrs

- count 符合要求的活动总数，同opt里的count
- acts 活动数组
- type 活动类别id
- typename 活动类别名称
- source 活动发起人
- time_status 活动报名状态
- time_status_str 活动报名状态字符
