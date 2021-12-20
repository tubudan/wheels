##Learning at work

### STAR原则
- Situation 情景
- Task 要做什么
- Action 怎么做
- Result 结果
### 正则表达式
**//TODO**
### 数据库事务
- 主要用于处理操作量大，复杂度较高的数据。比如人员管理系统中，删除一个人，你需要删除该人员的基本资料，以及他活动的相关资料。那么这些操作语句就构成一个事务。MySQL中只有innodb数据库引擎才支持事务；事务的处理能够维护数据库的完整性，保证SQL语句要么全部执行，要么全部不执行。
- 事务必须满足4个特性（ACID）：
	- 原子性：要么全部执行，要么全部不执行。
	- 一致性：在事务开始之前和事务结束以后，数据库的完整性没有被破坏。
	- 隔离性：数据库允许多个并发事务同时对其数据进行读写和修改的能力，隔离性可以防止多个事务并发执行时由于交叉执行而导致数据的不一致。
		- 读未提交（Read uncommitted）：
		- 读提交（read committed）：
		- 可重复读（repeatable read）：
		- 串行化（Serializable）：
	- 持久性：事务处理结束后，对数据的修改就是永久的，即便系统故障也不会丢失
- 数据库引擎：
	- innodb
	- myisam
- 索引
	- 单列索引：单个column
	- 组合索引：多column
	###Git Bash
- 添加自定义命令
	- 示例说明：#!/bin/sh 表示是shell脚本；第二行第一个参数表示exe文件的安装目录，第二个参数$1表示命令行输入参数，第三个参数&表示后台执行，不会阻塞git bash；
- step：
	- 新建文件，文件名为想要的命令代码，比如subl，**文件不能后缀**
	- 文件内容如下
				
			#!/bin/sh 
			"sublime的安装目录下\sublime_text.exe" $1 &
	- 将subl	文件放到git安装目录 Git\mingw64\bin下



###Java 
- 框架
	- Spring boot
		- 配置文件：
		
				参考：https://blog.csdn.net/fyhailin/article/details/79413864
				pom.xml
				application.properties/application.yml:
		- 表现层（Spring MVC）：Controller
		- 业务层（Spring）：Service
		- 持久层（Mybatis）：Dao（Mapper）
		- 视图层：View
		- 运行过程：
		  
				 JSP/HTML ==> Controller层 ==> Service层   ==> DAO层数 ==> 数据
			 	 (View层) <==  接受用户请求 <== 完成业务逻辑 <==  据库操作 <==  库
	- Mybatis
		- 配置：
		- 标签语法：
			- trim
	
	 	// trim标签在sql拼接时去除多余的where、and
	 	// SQL:select * from BLOG where state = #{state} and tittle like #{title} and author_name like #{author.name}\
	 	<select id="findActiveBlogLike" resultType="Blog">
	 	    SELECT * FROM BLOG
	 	    <trim prefix="WHERE" prefixOverrides="AND">
	 	        <if test="state != null">
	 	                state = #{state}
	 	        </if> 
	 	        <if test="title != null">
	 	                     AND title like #{title}
	 	        </if>
	 	        <if test="author != null and author.name != null">
	 	            AND author_name like #{author.name}
	 	        </if>
	 	    </trim>
	 	</select>
	
- 通用知识

     - 注解：

          - @Autowired（现在已不被推荐使用）：只会根据type匹配bean，name靠@Qualifier(name="xxx")，虽然灵活但是不可靠，灵活指的是可以用在变量、setter方法、构造方法，原理是通过反射机制实现，因此可以用在private的成员；不可靠是由于类的加载顺序可能会导致注入null，建议强制依赖使用构造器，非必须依赖使用setter方法注入

          - @Resource：可以指定name 和 type 属性，装配时根据已提供的属性（1个或2个）匹配唯一bean，找不到或者匹配到多个会抛异常

               

  - HTTP状态码
        10X：响应状态码，仅在与http服务器沟通时用
       	- 20X：表示操作成功
       		- 201 Created
       		- 202 Accepted
       	- 30X：重定向
       		- 301 永久重定向
       		- 302 临时重定向
       		- 303 POST请求已经被处理
       		- 307 POST请求没有被处理，向Location里的URI重新发起POST请求
       	- 40X：客户端错误
       		- 401 http认证失败
       		- 403 请求资源被服务器拒绝访问
       		- 404 资源没有在服务器找到
       	- 50X：服务器错误
       		###数据库

- 数据库引擎：
	- InnoDB
	- MyISAM
	- ISAM
	
- 关系型数据库
	- 概念：典型的数据结构是表，由二维表及表之间的关系组成的数据组织
	- 优点：表结构方便维护，SQL语言通用使用方便，**支持复杂sql查询（待学习）**
	- 缺点：读写性能差，固定表结构不灵活，高并发读写需求受限于磁盘I/O
	- 例如：
		- MySQL 
		- Oracle
		- MariaDB 
		- SQL Server
		- PostgreSQL
	
- 非关系型数据库（涉及高并发、大数据）

  - 概念：严格来说并不是一种数据库，而是一种数据结构化存储方法的集合，可以是文档、键值对等。

 	- 优点：
	 	- 格式灵活，存储形式多样，如key-value，文档，图片。（关系型数据库只支持基础数据类型）
	 	- 速度快，NoSQL可以使用任意存储器作为载体，关系型数据库只能用硬盘
	 	- 高拓展性？
	 	- 成本低，基本上都是开源，且部署方便。
	
 	- 缺点：
	 	- 不提供SQL支持
	 	- 没有事务处理
	 	- 数据结构复杂，复杂查询困难
	
  - 例如：【**DB：数据库类型，应用场景**】
        列存储数据库：分布式存储
       	 	- HBase
       	 	- Cassandra	
       	- Key-Value数据库：内容缓存
       		- Redis
       	- 文档型数据库:
       		- MongoDB
       		- CouchDB
       	- 图形数据库：社交网络或者推荐系统
       		- Neo4j
       ###设计模式

- 存在的意义：根据特定的场景提供一种可维护性强可拓展性高的解决方案，避免重复性的工作

- 类别：
	- 创建型模式（创建对象 6种）
		- 单例模式
			- 三要素：
				- 一个类有且只有一个实例；类自己创建唯一实例;向整个系统提供该唯一实例
			- 例如：windows系统的任务管理器
			<pre>Class TaskManager{
			   private static TaskManager tm = null;
			   private TaskManager(){...}
			   public void displayProgress(){...}
			   public void displayServices(){...}
			   public static TaskManager getInstance(){
			   if(tm == null){
			       tm = new TaskManager();
			      }
			    return tm;
			   }		
			 } </pre>
		- 简单工厂模式
		- 工厂方法模式
		- 抽象工厂模式
		- 原型模式
		- 建造者模式
	- 结构型模式（组合对象 7种）
		- 适配器模式
		- 桥接模式
		- 组合模式
		- 装饰模式
		- 外观模式
		- 享元模式
		- 代理模式
	- 行为型模式（描述对象或分配职责 11种）
		- 职责链模式
		- 命令模式
		- 解释器模式
		- 迭代器模式
		- 中介者模式
		- 备忘录模式
		- 观察者模式
		- 状态模式
		- 策略模式
		- 模板方法模式
		- 访问者模式
	
- five principle:
	- 单一责任原则：修改类的原因应该只有一个
	- 开放封闭原则：（软件实体）对拓展开放；对修改关闭；关键是要对系统抽象化。
	- 里氏替换原则：实现抽象的规范，实现子父类互相替换（子类对象必须能够替换掉所有父类对象）
	- 接口隔离原则：降低耦合度，接口单独设计，互相隔离（不应该强迫客户依赖于它们不用的方法。）
	- 依赖倒转原则：针对接口编程，实现开闭原则的基础（高层对象不应该依赖于低层模块，二者应该都依赖于抽象，抽象不应该依赖于细节）
	
- 其它常用原则
	- 迪米特法则：最少知道原则，功能模块相互独立
	- 合成复用原则：尽量使用合成、聚合，尽量不使用继承
	
- 设计模式示例
	- 工厂模式：定义一个创建对象的接口，让子类决定实例化哪一个工厂类，创建对象过程延迟到子类执行
	- 抽象工厂模式：创建一系列相关或者相互依赖的对象的接口，无需指定具体的类
	- 单例模式：
	###SourceTree
	###系统安装软件错误跟踪
	
- SxsTrace工具使用

- 所有微软的包下载时不用百度，直接用bing

- Vue：

     - 实例中模块加载

          ```
          computed：计算属性将被混入到Vue实例中，用于绑定属性，所有getter、setter的this自动绑定为Vue实例【HTML DOM加载后马上执行】
          methods：【methods需要条件触发】
          watch：观察响应vue实例的数据变动，Vue实例在变动时调用$watch()【数据变动时】
          created：html加载前执行。先父组件再儿子
          mounted：html加载后执行。先子组件再父亲
          加载顺序：prop=>data=>computed=>method
          ```

     ## INTERVIEW

- Project：
  - 接口限流方式：避免服务被调挂
    - 计数器算法：限制1s的请求数，可能前10ms耗尽qps，后990ms只能拒绝请求；AtomicLong，AtomicLong.decrementAndGet()
    - 漏桶算法：10ms处理一次请求，所有请求全部放在桶中，桶满则拒绝请求，不能应对短期高并发；线程池、队列
    - 令牌桶算法：桶中按照一定速率放入token，桶存放token的数量有限，达到上限就不放，数量为0就阻塞或拒绝请求。可以改变速率和并发上限；Semaphore、RateLimiter

- 八股文：

  - Java 8 新特性：
    - interface：default（this调用，可以被继承、重写）、static修饰（interface调用，不能被继承）
  - JVM
    - 垃圾回收
      - 新生代（PSYoungGen），老年代（ParOldGen），元空间（Metaspace）
      - Minor GC/Young GC、Major GC/Old GC、Mixed GC、Full GC
      - 判断对象死亡：引用计数器法、可达性分析法（GC Roots：虚拟机栈、本地方法栈、静态属性引用的对象，常量，同步锁持有的对象）
      - 垃圾收集算法：标记-清除（不连续碎片）、标记-复制、标记-整理、分代收集
    - 内存模型：
      - 程序计数器：当前线程执行的字节码行号指示器，线程切换时需要恢复正确执行位置，且各个线程互不影响，**线程私有**
      - java虚拟机栈：执行java方法，存放局部变量表、操作数栈、动态链接、方法出口，**线程私有**
      - 本地方法栈：虚拟机使用的native方法 c、c++，**线程私有**
      - 方法区：存储类信息、`常量`、`静态变量`，**线程共享**
      - 堆：存放对象实例，GC主要区域，**线程共享**
    - 类加载：加载=>连接（验证》准备》解析）=>初始化
      - 类加载器：**BootstrapClassLoader**、**ExtensionClassLoader**、**AppClassLoader**
      - 双亲委派模型：每个类都有一个它的类加载器。类加载的时候，系统会首先判断当前类是否被加载过。已经被加载的类会直接返回，否则才会尝试加载。加载的时候，首先会把该请求委派给父类加载器的 `loadClass()` 处理，因此所有的请求最终都应该传送到顶层的启动类加载器 `BootstrapClassLoader` 中。当父类加载器无法处理时，才由自己来处理。当父类加载器为 null 时，会使用启动类加载器 `BootstrapClassLoader` 作为父类加载器。
  - 常用数据结构
    - HashMap：原理
    - ConcurrentHashMap：线程安全原理、导致问题、1.7、1.8区别
      - 1.7 对整个桶进行了分割分段（segment），每次只锁其中一部分，多线程访问不同segment不存在锁竞争，提高了并发率
      - 1.8 直接用Node数组+链表/红黑树，并发控制采用synchronized和CAS操作（HashTable效率低现在基本弃用，加锁时不能get也不能put）
  - 中间件
    - 消息队列：ActiveMQ、RocketMQ、RabbitMQ、Kafka
      - 场景：异步处理，应用解耦（订单系统-库存系统），流量削峰（秒杀控制参与人数），消息通讯
      - 
  - 多线程
       - 线程池配置：CPU密集型（CPU核心数+1）；IO密集型（CPU核心数*2）
       - 继承Thread：无返回值，重写run方法
       - 实现runnable：无返回值，重写run方法
       - 实现callable：有返回值（Future 对象），实现call方法
  - 设计模式：**TODO**
  - 锁：1.6对synchronized关键字做了底层优化
       - 状态：无锁、偏向锁、轻量级锁、重量级锁
       - synchronized 
       - volatile
  - AQS（AbstractQueuedSynchronizer）：AQS 是一个用来构建锁和同步器的框架，使用 AQS 能简单且高效地构造出大量应用广泛的同步器，比如我们提到的 `ReentrantLock`，`Semaphore`，其他的诸如 `ReentrantReadWriteLock`，`SynchronousQueue`，`FutureTask` 等等皆是基于 AQS 的。
       - 原理：如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效线程，并锁定共享资源。如果被请求的共享资源被占用，那么就需要一套线程阻塞等待以及被唤醒时锁分配的机制。**CLH（虚拟双向队列）**
  - 分布式：**TODO**
  - Redis：16384个桶，存放变化量不大的热点数据
  
    - 数据结构：String、Hash、List、Set、sort-set
    - 特点：快、高性能
    - 单个value最大限制大小是1G
    - 单线程但是速度快的原因：完全基于内存，数据结构和数据操作简单，（采取单线程避免了线程之间的竞争和切换、上下文切换带来的cpu性能消耗；），单线程模式使得Redis并发没有竞争，并发操作变串行访问，因此如果发生数据错误、阻塞，原因均来自于客户端
    - 删除策略：定时删除（过期时间+定时任务，内存友好型）、惰性删除（每次get的时候查询是否过期，是则删除；CPU友好型）、定期删除（每隔一段时间就删除）
    - 事务：（跟其它事务特性一样：都执行或都不执行、顺序执行、事务执行过程中不会被插入）
      - 一旦开始事务，不为其它客户端提供服务，一保证事务原子执行
      - 事务中如果有命令执行失败，事务不会回滚，后续命令依然会执行。类似批量执行的脚本（Multi-Exec/Discard）
  
    - Redis分布式锁的实现：**TODO**
  
    - 持久化：
  
      - RDB（存的每个时间点的数据集，dump.rdb）/AOF（存放写操作命令，appendonly.aof）
  
      - 混合持久化：RDB全量持久化、AOF增量持久化；Redis重启时，RDB重建内存，AOF重放近期操作指令恢复
  
    - 发布/订阅 publish  channel message / subscribe channel：5.0版本新增了Redis Stream用于消息队列（持久化，主备复制）
    - mysql和redis如何保持数据一致