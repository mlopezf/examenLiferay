package com.telefonica.talentum.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.telefonica.talentum.model.Usuario;
import com.telefonica.talentum.service.UsuarioLocalService;
import com.telefonica.talentum.service.persistence.UsuarioPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the usuario local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.telefonica.talentum.service.impl.UsuarioLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.telefonica.talentum.service.impl.UsuarioLocalServiceImpl
 * @see com.telefonica.talentum.service.UsuarioLocalServiceUtil
 * @generated
 */
public abstract class UsuarioLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements UsuarioLocalService, IdentifiableBean {
    @BeanReference(type = com.telefonica.talentum.service.UsuarioLocalService.class)
    protected com.telefonica.talentum.service.UsuarioLocalService usuarioLocalService;
    @BeanReference(type = com.telefonica.talentum.service.UsuarioService.class)
    protected com.telefonica.talentum.service.UsuarioService usuarioService;
    @BeanReference(type = UsuarioPersistence.class)
    protected UsuarioPersistence usuarioPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private UsuarioLocalServiceClpInvoker _clpInvoker = new UsuarioLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.telefonica.talentum.service.UsuarioLocalServiceUtil} to access the usuario local service.
     */

    /**
     * Adds the usuario to the database. Also notifies the appropriate model listeners.
     *
     * @param usuario the usuario
     * @return the usuario that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Usuario addUsuario(Usuario usuario) throws SystemException {
        usuario.setNew(true);

        return usuarioPersistence.update(usuario);
    }

    /**
     * Creates a new usuario with the primary key. Does not add the usuario to the database.
     *
     * @param userId the primary key for the new usuario
     * @return the new usuario
     */
    @Override
    public Usuario createUsuario(long userId) {
        return usuarioPersistence.create(userId);
    }

    /**
     * Deletes the usuario with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param userId the primary key of the usuario
     * @return the usuario that was removed
     * @throws PortalException if a usuario with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Usuario deleteUsuario(long userId)
        throws PortalException, SystemException {
        return usuarioPersistence.remove(userId);
    }

    /**
     * Deletes the usuario from the database. Also notifies the appropriate model listeners.
     *
     * @param usuario the usuario
     * @return the usuario that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Usuario deleteUsuario(Usuario usuario) throws SystemException {
        return usuarioPersistence.remove(usuario);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Usuario.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return usuarioPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.telefonica.talentum.model.impl.UsuarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return usuarioPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.telefonica.talentum.model.impl.UsuarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return usuarioPersistence.findWithDynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return usuarioPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return usuarioPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Usuario fetchUsuario(long userId) throws SystemException {
        return usuarioPersistence.fetchByPrimaryKey(userId);
    }

    /**
     * Returns the usuario with the primary key.
     *
     * @param userId the primary key of the usuario
     * @return the usuario
     * @throws PortalException if a usuario with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Usuario getUsuario(long userId)
        throws PortalException, SystemException {
        return usuarioPersistence.findByPrimaryKey(userId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return usuarioPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the usuarios.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.telefonica.talentum.model.impl.UsuarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of usuarios
     * @param end the upper bound of the range of usuarios (not inclusive)
     * @return the range of usuarios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Usuario> getUsuarios(int start, int end)
        throws SystemException {
        return usuarioPersistence.findAll(start, end);
    }

    /**
     * Returns the number of usuarios.
     *
     * @return the number of usuarios
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getUsuariosCount() throws SystemException {
        return usuarioPersistence.countAll();
    }

    /**
     * Updates the usuario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param usuario the usuario
     * @return the usuario that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Usuario updateUsuario(Usuario usuario) throws SystemException {
        return usuarioPersistence.update(usuario);
    }

    /**
     * Returns the usuario local service.
     *
     * @return the usuario local service
     */
    public com.telefonica.talentum.service.UsuarioLocalService getUsuarioLocalService() {
        return usuarioLocalService;
    }

    /**
     * Sets the usuario local service.
     *
     * @param usuarioLocalService the usuario local service
     */
    public void setUsuarioLocalService(
        com.telefonica.talentum.service.UsuarioLocalService usuarioLocalService) {
        this.usuarioLocalService = usuarioLocalService;
    }

    /**
     * Returns the usuario remote service.
     *
     * @return the usuario remote service
     */
    public com.telefonica.talentum.service.UsuarioService getUsuarioService() {
        return usuarioService;
    }

    /**
     * Sets the usuario remote service.
     *
     * @param usuarioService the usuario remote service
     */
    public void setUsuarioService(
        com.telefonica.talentum.service.UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Returns the usuario persistence.
     *
     * @return the usuario persistence
     */
    public UsuarioPersistence getUsuarioPersistence() {
        return usuarioPersistence;
    }

    /**
     * Sets the usuario persistence.
     *
     * @param usuarioPersistence the usuario persistence
     */
    public void setUsuarioPersistence(UsuarioPersistence usuarioPersistence) {
        this.usuarioPersistence = usuarioPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.telefonica.talentum.model.Usuario",
            usuarioLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.telefonica.talentum.model.Usuario");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Usuario.class;
    }

    protected String getModelClassName() {
        return Usuario.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = usuarioPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}