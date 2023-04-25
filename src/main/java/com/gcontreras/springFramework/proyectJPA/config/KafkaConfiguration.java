package com.gcontreras.springFramework.proyectJPA.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    /**
     * Consumer
     */
    private Map<String, Object> consumerProps() { Map<String, Object>props=new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092"); //Lista de brokers de kafka en el cluster.
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"PruebaGroup"); //Identificador,Consumer group que consumirá los mensajes
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true); //Determina si se hará commit al offset
                                                                    // de forma periódica
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"100"); //Determina la frecuencia en milisegundos en
                                                                        //la que se hará commit a los offsets,
                                                                        //solo es necesaria si.
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,"15000"); //Tiene una session con ese tiempo de vida,
                                                                    //Timeout utilizado para determinar errores
                                                                    // en los clientes.
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                IntegerDeserializer.class); //Clase a utilizar para deserializar la llave,
                                            // La llave va a ser de tipo Entero (IntegerDeserializer)
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class); //Clase a utilizar para deserializar el mensaje
                                            // Y el valor va hacer de tipo String (StringDeserializer)
        return props;
    }
    //configurar el listening,
    // nos permite poder recibir los mensajes y poder hacer algo con esos mensajes.
    @Bean
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerProps());
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, String>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


    /**
     * Producer
     * define grupos de mensaje a enviar
     */
    private Map<String, Object> producerProps() { Map<String, Object> props=new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.RETRIES_CONFIG, 0); //Define los reintentos que se realizarán en caso de error.
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384); //producer agrupará los registros en batches,
                                                            // mejorando la performance (está definido en bytes).
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1); //Los batches se agruparán de acuerdo de un periodo de tiempo,
                                                            // está definido en milisegundos.
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432); // Define el espacio de memoria que se asignará
                                                                    // para colocar los mensajes que están
                                                                        // pendientes por enviar.
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }
    @Bean
    public KafkaTemplate<Integer, String> createTemplate() { Map<String, Object>senderProps= producerProps();
        ProducerFactory<Integer, String> pf= new DefaultKafkaProducerFactory<Integer, String>(senderProps);
        KafkaTemplate<Integer, String> template= new KafkaTemplate<>(pf);
        return template;
    }
}
