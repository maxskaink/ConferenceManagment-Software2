# Usa la imagen base oficial de RabbitMQ con la consola de administración
FROM rabbitmq:3-management

# Configura las credenciales predeterminadas
ENV RABBITMQ_DEFAULT_USER=guest
ENV RABBITMQ_DEFAULT_PASS=guest

# Expone los puertos necesarios
EXPOSE 5672 5672
EXPOSE 15672 15672

# Comando de entrada para iniciar RabbitMQ
CMD ["rabbitmq-server"]
