FROM postgres:15

# Set environment variables for PostgreSQL
ENV POSTGRES_DB=citis_db
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=123

# Expose PostgreSQL port
EXPOSE 5432