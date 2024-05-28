package br.com.nomeempresa.restaurante.adapters.inbound.types;

import br.com.nomeempresa.restaurante.core.domain.entities.Categoria;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class CategoriaType implements UserType<Categoria> {

    public static final CategoriaType INSTANCE = new CategoriaType();

    @Override
    public int getSqlType() {
        return Types.OTHER;
    }

    @Override
    public Class<Categoria> returnedClass() {
        return Categoria.class;
    }

    @Override
    public boolean equals(Categoria x, Categoria y) {
        return x.equals(y);
    }

    @Override
    public int hashCode(Categoria x) {
        return Objects.hashCode(x);
    }

    @Override
    public Categoria nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session,
                              Object owner) throws SQLException {
        String columnValue = (String) rs.getObject(position);
        if (rs.wasNull()) {
            columnValue = null;
        }

        return Categoria.fromCode(columnValue);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Categoria value, int index,
                            SharedSessionContractImplementor session) throws SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
        }
        else {
            st.setObject(index, value, Types.OTHER);
        }
    }

    @Override
    public Categoria deepCopy(Categoria value) {
        return value == null ? null : Categoria.fromCode(value.getCode());
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Categoria value) {
        return deepCopy(value);
    }

    @Override
    public Categoria assemble(Serializable cached, Object owner) {
        return deepCopy((Categoria) cached);
    }

    @Override
    public Categoria replace(Categoria detached, Categoria managed, Object owner) {
        return deepCopy(detached);
    }
}
