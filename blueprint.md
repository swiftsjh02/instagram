<div style="text-align: center;"><h1>The Blueprint</h1></div>

## Basic information

* name: instagram
* description: Instagram protocol
* author: 김예지, 김의진, 서지호, 조태완
* version: 1.0.0
* license: MITs
* university: Gachon University
* department: Artificial Intelligence
* email: taewan2002@gachon.ac.kr, ksdk6145@gachon.ac.kr
* last update: 2022-11-23

## Database tables

### `chat_manager`
* `chat_id`: char(70)
* `member`: int

### `chat_table`
* `chat_room_id`: char(70)
* `chat_file`: char(70)

### `comment`
* `comment_id`: int, primary key
* `content`: varchar(2000)
* `perrent_id`: int
* `user_id`: int unsigned
* `post_id`: int unsigned

### `follow`
* `follow_id`: int, primary key
* `follower_id`: int
* `following`: int

### `hashtag`
* `hashtag_id`: int, primary key
* `hashtag`: varchar(30)

### `image`
* `image_id`: int, primary key
* `file_name`: varchar(2000)
* `post_id`: int unsigned

### `online_user`
* `session_id`: int
* `user_id`: int, primary key

### `post`
* `post_id`: int, primary key
* `content`: tinytext
* `location`: varchar(30)
* `user_id`: int

### `post_hashtag`

* `post_hashtag_id`: int
* `post_id`: int
* `hashtag_id2`: int

### `User`
* `user_id`: int(auto increment), primary key
* `email`: varchar(50)
* `password`: varchar(200)
* `phone`: varchar(11)
* `gender`: enum('male','female')
* `name`: varchar(10)
* `nickname`: varchar(10)
* `website`: varchar(50)
* `introduce`: varchar(100)
* `profile_image`: tinytext

### `user_comment_like`
* `user_comment_like_id`: int, primary key
* `user_id`: int unsigned
* `comment_id`: int unsigned

### `user_comment_tag`
* `user_comment_tag_id`: int, primary key
* `user_id`: int unsigned
* `comment_id`: int unsigned

### `user_post_like`
* `user_post_like_id`: int, primary key
* `user_id`: int unsigned
* `post_id`: int unsigned

### `user_post_tag`
* `user_post_tag_id`: int, primary key
* `user_id`: int unsigned
* `post_id`: int unsigned

## Chatting protocol

* use protocol.java file

### `packet format for make chatting room`

|        type         |     name      |       description        |
|:-------------------:|:-------------:|:------------------------:|
|         int         | typeofrequest |  type of request number  |
|         int         |    sender     | user_id of requst member |
| ArrayList\<Integer> |     list      |   invite chat members    |


### `packet format for invite chatting room`

|        type         |     name      |        description        |
|:-------------------:|:-------------:|:-------------------------:|
|         int         | typeofrequest |  type of request number   |
|         int         |    sender     | user_id of requst member  |
|       String        |  roomnumber   | chat room number with md5 |
| ArrayList\<Integer> |     list      |    invite chat members    |

### `packet format for remove chatting room`

|        type         |     name      |        description        |
|:-------------------:|:-------------:|:-------------------------:|
|         int         | typeofrequest |  type of request number   |
|         int         |    sender     | user_id of requst member  |
|       String        |  roomnumber   | chat room number with md5 |

### `packet format for send message`

|  type   |     name      |                description                |
|:-------:|:-------------:|:-----------------------------------------:|
|   int   | typeofrequest |          type of request number           |
| String  |  roomnumber   |         chat room number with md5         |
|   int   |    sender     |         user_id of requst member          |
|   int   |    message    |              message content              |
| String  |     time      |          time when send messege           |
| boolean |  file_exist   |        Determine if a file exists         |
| String  |   file_path   | Storage Location of sended file in server |

### `request of chat room list`
|  type   |     name      |                description                |
|:-------:|:-------------:|:-----------------------------------------:|
|   int   | typeofrequest |          type of request number           |


## Create room number

* `roomnumber`: md5(number of members + user_id of members + time)
* https://en.wikipedia.org/wiki/MD5





