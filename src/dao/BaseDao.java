package dao;

import java.util.List;

import util.Page;

public interface BaseDao {
	/**
	 * 将一个实体类持久化，写入到数据库中，在具体使用中需要将一个对象传到方法中
	 * 
	 * @param t
	 *            需要持久化操作的实体类
	 * @return 如果持久化操作成功，则返回<strong>"success"</strong>，反之返回<strong>"error"+持久化操作错误消息</strong>，但是当传入的对象t为空时，则直接返回"error"
	 */
	public <T> String add(T t);

	/**
	 * 从数据库中删除一条记录，需要指定删除的记录对应的对象
	 * 
	 * @param t
	 *            需要删除的记录中的对象
	 * @return 如果删除操作成功，则返回<strong>"success"</strong>，反之返回<strong>"error"+持久化操作错误消息</strong>，但是当传入的对象t为空时，则直接返回"error"
	 */
	public <T> String delet(T t);

	/**
	 * 更新数据库中的一条记录
	 * 
	 * @param t
	 *            需要更新的记录中的对象
	 * @return 如果更新操作成功，则返回<strong>"success"</strong>，反之返回<strong>"error"+持久化操作错误消息</strong>，但是当传入的对象t为空时，则直接返回"error"
	 */
	public <T> String update(T t);

	/**
	 * 根据id查找对应的记录
	 * 
	 * @param t
	 *            返回对应的对象
	 * @param id
	 *            需要查找记录的对象的id
	 * @return 如果查找到记录则返回该记录的对象，明确该对象只有一个，如果发生异常和没有记录都返回null
	 */
	public <T> T getById(T t, int id);

	/**
	 * 分页查询，根据查询指定页数和每页显示最大记录数获取查询结果
	 * 
	 * @param <T>
	 * 
	 * @param t
	 *            查询的对象，泛型定义
	 * @param page
	 *            查询页数，Page封装了每页查询最大记录数、上一页、下一页、当前页和总页数，总页数需要手动设置。当然提供了自动设置属性的方法
	 *            autoSetter(int pageIndex, int totalPages)，需要手动传入当前页数和总页数
	 * @return 根据分页查询的结果返回一组该对象的List集合，如果发生异常和没有记录都返回null
	 */
	public <T> List<T> getByPage(T t, Page page);
}
