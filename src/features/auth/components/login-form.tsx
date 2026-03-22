import { useMagicAuth } from "../hooks/magic-auth";
import { FieldGroup, FieldSeparator } from "@/components/ui/field";
import OAuthButton from "./oauth-button";
import EmailForm from "./email-form";

export const LoginForm = () => {
  const { isLoading, login } = useMagicAuth();
  return (
    <FieldGroup>
      <OAuthButton />
      <FieldSeparator>Hoặc tiếp tục với</FieldSeparator>
      <EmailForm onSubmit={login} loading={isLoading} />
    </FieldGroup>
  );
};
