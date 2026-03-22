import { Button } from "@/components/ui/button";
import { Google } from "@thesvg/react";
import { useMagicOAuth } from "../hooks/magic-oauth";
import { Spinner } from "@/components/ui/spinner";

const OAuthButton = () => {
  const { isLoading, loginWithGoogle } = useMagicOAuth();
  return (
    <Button
      size={"lg"}
      variant={"outline"}
      className='relative'
      onClick={loginWithGoogle}
    >
      {isLoading ? (
        <Spinner />
      ) : (
        <>
          <Google className='absolute left-4' />
          Tiếp tục với Google
        </>
      )}
    </Button>
  );
};

export default OAuthButton;
