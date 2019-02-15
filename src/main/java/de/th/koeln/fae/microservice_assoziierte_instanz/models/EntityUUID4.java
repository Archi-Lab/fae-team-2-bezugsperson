package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class EntityUUID4 {

    @Id
    private UUID id;

    public EntityUUID4(final UUID id) {
        this.id = id;
    }

    public EntityUUID4() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EntityUUID4)) {
            return false;
        }

        final EntityUUID4 other = (EntityUUID4) obj;
        final EqualsBuilder eb = new EqualsBuilder();

        eb.append(this.getId(), other.getId());

        return eb.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();

        hcb.append(this.getId());

        return hcb.toHashCode();
    }
}
