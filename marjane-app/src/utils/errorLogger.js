/**
 * Centralized error logging utility.
 * Logs errors to console and can be extended to send errors to remote monitoring services.
 */

const logError = (error, context = '') => {
  if (context) {
    console.error(`Error in ${context}:`, error);
  } else {
    console.error('Error:', error);
  }

  // TODO: Add remote logging here, e.g., send to Sentry, LogRocket, etc.
};

export default logError;
