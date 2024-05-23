package br.com.nomeempresa.restaurante.adapters.inbound.types;

import br.com.nomeempresa.restaurante.adapters.inbound.entity.CategoriaEnum;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class CategoriaType implements UserType<CategoriaEnum> {

    public static final CategoriaType INSTANCE = new CategoriaType();

    @Override
    public int getSqlType() {
        return Types.OTHER;
    }

    @Override
    public Class<CategoriaEnum> returnedClass() {
        return CategoriaEnum.class;
    }

    @Override
    public boolean equals(CategoriaEnum x, CategoriaEnum y) {
        return x.equals(y);
    }

    @Override
    public int hashCode(CategoriaEnum x) {
        return Objects.hashCode(x);
    }

    @Override
    public CategoriaEnum nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session,
                              Object owner) throws SQLException {
        String columnValue = (String) rs.getObject(position);
        if (rs.wasNull()) {
            columnValue = null;
        }

        return CategoriaEnum.fromCode(columnValue);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, CategoriaEnum value, int index,
                            SharedSessionContractImplementor session) throws SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
        }
        else {
            st.setObject(index, value, Types.OTHER);
        }
    }

    @Override
    public CategoriaEnum deepCopy(CategoriaEnum value) {
        return value == null ? null : CategoriaEnum.fromCode(value.getCode());
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(CategoriaEnum value) {
        return deepCopy(value);
    }

    @Override
    public CategoriaEnum assemble(Serializable cached, Object owner) {
        return deepCopy((CategoriaEnum) cached);
    }

    @Override
    public CategoriaEnum replace(CategoriaEnum detached, CategoriaEnum managed, Object owner) {
        return deepCopy(detached);
    }
}
