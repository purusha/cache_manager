package org.redisson.config;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import org.redisson.codec.Kryo5Codec;

/**
 * Used to change the default serializer of Kryo 5 to make redisson forward and backward compatible, see @{@link CompatibleFieldSerializer}
 */
public class CompatibleKryo5Codec extends Kryo5Codec {

    @Override
    protected Kryo createKryo(ClassLoader classLoader) {
        Kryo kryo = super.createKryo(classLoader);
        kryo.setDefaultSerializer(CompatibleFieldSerializer.class);
        return kryo;
    }
}
