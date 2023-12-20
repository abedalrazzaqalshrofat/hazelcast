package io.arabot.hazelcastspringbootpoc;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientReliableTopicConfig;
import com.hazelcast.client.impl.clientside.HazelcastClientInstanceImpl;
import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import com.hazelcast.topic.TopicOverloadPolicy;
import io.arabot.hazelcastspringbootpoc.beans.StudentSerializer;
import io.arabot.hazelcastspringbootpoc.models.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableCaching
public class HazelcastSpringbootPocApplication {
	public static void main(String[] args) {

		SpringApplication.run(HazelcastSpringbootPocApplication.class, args);
	}

//	@Bean
//	public Config createConfig() {
//		var config = new Config();
//		config.setClusterName("hazelcast-cluster");
//		config.setProperty("hazelcast.logging.type", "log4j2"); // Example for Log4j2
//		config.setInstanceName("hazelcast-instance");
//		config.addMapConfig(mapConfig());
//		RingbufferConfig ringbufferConfig = new RingbufferConfig("default");
//		ringbufferConfig.setCapacity(10000000)
//				.setTimeToLiveSeconds(5);
//		config.addRingBufferConfig(ringbufferConfig);
//		ClientConfig clientConfig = new ClientConfig();
//		ClientReliableTopicConfig topicConfig = new ClientReliableTopicConfig("default");
//		topicConfig.setTopicOverloadPolicy( TopicOverloadPolicy.BLOCK )
//				.setReadBatchSize( 10 );
//		clientConfig.addReliableTopicConfig(topicConfig);
//		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
//		ITopic topic = client.getReliableTopic(topicConfig.getName());
//		config.getJetConfig().setEnabled(true);
//		config.getNetworkConfig().getRestApiConfig().setEnabled(true);
//		config.getSerializationConfig().addSerializerConfig(serializerConfig());
//		return config;
//	}
//
//	@Bean
//	public HazelcastInstance hazelcastInstance(){
//		return Hazelcast.getOrCreateHazelcastInstance(createConfig());
//	}
//
//	private SerializerConfig serializerConfig() {
//		return new SerializerConfig().setImplementation(new StudentSerializer()).setTypeClass(Student.class);
//	}
//
//
//
//	private MapConfig mapConfig() {
//		var mapConfig = new MapConfig("student");
//		mapConfig.setNearCacheConfig(nearCacheConfig());
//		mapConfig.setTimeToLiveSeconds(360);
//		mapConfig.setMaxIdleSeconds(400);
//		return mapConfig;
//	}
//
//	private NearCacheConfig nearCacheConfig(){
//		return new NearCacheConfig()
//				.setName("myDataStructure")
//				.setInMemoryFormat(InMemoryFormat.BINARY)
//				.setSerializeKeys(true)
//				.setInvalidateOnChange(false)
//				.setTimeToLiveSeconds(1)
//				.setMaxIdleSeconds(60 * 60)
//				.setEvictionConfig(evictionConfig())
//				.setCacheLocalEntries(true)
//				.setLocalUpdatePolicy(NearCacheConfig.LocalUpdatePolicy.CACHE_ON_UPDATE)
//				.setPreloaderConfig(nearCachePreloaderConfig());
//	}
//
//	public EvictionConfig evictionConfig(){
//        return new EvictionConfig()
//				.setMaxSizePolicy(MaxSizePolicy.ENTRY_COUNT)
//				.setEvictionPolicy(EvictionPolicy.LRU)
//				.setSize(1);
//	}
//
//	public NearCachePreloaderConfig nearCachePreloaderConfig(){
//		return new NearCachePreloaderConfig()
//				.setEnabled(true)
//				.setDirectory("nearcache-example")
//				.setStoreInitialDelaySeconds( 1 )
//				.setStoreIntervalSeconds(2);
//	}
}
