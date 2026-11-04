# Dockerfile
FROM postgres:17-alpine

ENV POSTGRES_DB=my_learning_db
ENV POSTGRES_USER=my_user
ENV POSTGRES_PASSWORD=my_password
ENV POSTGRES_ROOT_PASSWORD=my_password

EXPOSE 5432

CMD ["postgres"]