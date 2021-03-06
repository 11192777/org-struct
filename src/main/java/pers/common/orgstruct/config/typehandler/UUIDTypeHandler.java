package pers.common.orgstruct.config.typehandler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@MappedTypes(UUID.class)
public class UUIDTypeHandler extends BaseTypeHandler<UUID> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UUID uuid, JdbcType jdbcType) throws SQLException {
        if (uuid != null) {
            preparedStatement.setString(i, uuid.toString());
        } else {
            preparedStatement.setString(i, null);
        }
    }

    @Override
    public UUID getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if (!StringUtils.isEmpty(resultSet.getString(s))) {
            return UUID.fromString(resultSet.getString(s));
        } else {
            return null;
        }
    }

    @Override
    public UUID getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if (!StringUtils.isEmpty(resultSet.getString(i))) {
            return UUID.fromString(resultSet.getString(i));
        } else {
            return null;
        }
    }

    @Override
    public UUID getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        if (!StringUtils.isEmpty(callableStatement.getString(i))) {
            return UUID.fromString(callableStatement.getString(i));
        } else {
            return null;
        }
    }
}
